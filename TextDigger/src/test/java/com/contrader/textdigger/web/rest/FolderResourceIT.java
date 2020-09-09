package com.contrader.textdigger.web.rest;

import com.contrader.textdigger.TextDiggerApp;
import com.contrader.textdigger.domain.Folder;
import com.contrader.textdigger.repository.FolderRepository;
import com.contrader.textdigger.service.FolderService;
import com.contrader.textdigger.service.dto.FolderDTO;
import com.contrader.textdigger.service.mapper.FolderMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link FolderResource} REST controller.
 */
@SpringBootTest(classes = TextDiggerApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class FolderResourceIT {

    private static final String DEFAULT_FOLDER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_FOLDER_NAME = "BBBBBBBBBB";

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private FolderMapper folderMapper;

    @Autowired
    private FolderService folderService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restFolderMockMvc;

    private Folder folder;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Folder createEntity(EntityManager em) {
        Folder folder = new Folder()
            .folderName(DEFAULT_FOLDER_NAME);
        return folder;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Folder createUpdatedEntity(EntityManager em) {
        Folder folder = new Folder()
            .folderName(UPDATED_FOLDER_NAME);
        return folder;
    }

    @BeforeEach
    public void initTest() {
        folder = createEntity(em);
    }

    @Test
    @Transactional
    public void createFolder() throws Exception {
        int databaseSizeBeforeCreate = folderRepository.findAll().size();
        // Create the Folder
        FolderDTO folderDTO = folderMapper.toDto(folder);
        restFolderMockMvc.perform(post("/api/folders")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(folderDTO)))
            .andExpect(status().isCreated());

        // Validate the Folder in the database
        List<Folder> folderList = folderRepository.findAll();
        assertThat(folderList).hasSize(databaseSizeBeforeCreate + 1);
        Folder testFolder = folderList.get(folderList.size() - 1);
        assertThat(testFolder.getFolderName()).isEqualTo(DEFAULT_FOLDER_NAME);
    }

    @Test
    @Transactional
    public void createFolderWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = folderRepository.findAll().size();

        // Create the Folder with an existing ID
        folder.setId(1L);
        FolderDTO folderDTO = folderMapper.toDto(folder);

        // An entity with an existing ID cannot be created, so this API call must fail
        restFolderMockMvc.perform(post("/api/folders")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(folderDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Folder in the database
        List<Folder> folderList = folderRepository.findAll();
        assertThat(folderList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllFolders() throws Exception {
        // Initialize the database
        folderRepository.saveAndFlush(folder);

        // Get all the folderList
        restFolderMockMvc.perform(get("/api/folders?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(folder.getId().intValue())))
            .andExpect(jsonPath("$.[*].folderName").value(hasItem(DEFAULT_FOLDER_NAME)));
    }
    
    @Test
    @Transactional
    public void getFolder() throws Exception {
        // Initialize the database
        folderRepository.saveAndFlush(folder);

        // Get the folder
        restFolderMockMvc.perform(get("/api/folders/{id}", folder.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(folder.getId().intValue()))
            .andExpect(jsonPath("$.folderName").value(DEFAULT_FOLDER_NAME));
    }
    @Test
    @Transactional
    public void getNonExistingFolder() throws Exception {
        // Get the folder
        restFolderMockMvc.perform(get("/api/folders/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateFolder() throws Exception {
        // Initialize the database
        folderRepository.saveAndFlush(folder);

        int databaseSizeBeforeUpdate = folderRepository.findAll().size();

        // Update the folder
        Folder updatedFolder = folderRepository.findById(folder.getId()).get();
        // Disconnect from session so that the updates on updatedFolder are not directly saved in db
        em.detach(updatedFolder);
        updatedFolder
            .folderName(UPDATED_FOLDER_NAME);
        FolderDTO folderDTO = folderMapper.toDto(updatedFolder);

        restFolderMockMvc.perform(put("/api/folders")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(folderDTO)))
            .andExpect(status().isOk());

        // Validate the Folder in the database
        List<Folder> folderList = folderRepository.findAll();
        assertThat(folderList).hasSize(databaseSizeBeforeUpdate);
        Folder testFolder = folderList.get(folderList.size() - 1);
        assertThat(testFolder.getFolderName()).isEqualTo(UPDATED_FOLDER_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingFolder() throws Exception {
        int databaseSizeBeforeUpdate = folderRepository.findAll().size();

        // Create the Folder
        FolderDTO folderDTO = folderMapper.toDto(folder);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFolderMockMvc.perform(put("/api/folders")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(folderDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Folder in the database
        List<Folder> folderList = folderRepository.findAll();
        assertThat(folderList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteFolder() throws Exception {
        // Initialize the database
        folderRepository.saveAndFlush(folder);

        int databaseSizeBeforeDelete = folderRepository.findAll().size();

        // Delete the folder
        restFolderMockMvc.perform(delete("/api/folders/{id}", folder.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Folder> folderList = folderRepository.findAll();
        assertThat(folderList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
