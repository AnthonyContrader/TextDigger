package com.contrader.textdigger.web.rest;

import com.contrader.textdigger.TextDiggerApp;
import com.contrader.textdigger.domain.InterestGroup;
import com.contrader.textdigger.repository.InterestGroupRepository;
import com.contrader.textdigger.service.InterestGroupService;
import com.contrader.textdigger.service.dto.InterestGroupDTO;
import com.contrader.textdigger.service.mapper.InterestGroupMapper;

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
 * Integration tests for the {@link InterestGroupResource} REST controller.
 */
@SpringBootTest(classes = TextDiggerApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class InterestGroupResourceIT {

    private static final String DEFAULT_INTEREST_GROUP = "AAAAAAAAAA";
    private static final String UPDATED_INTEREST_GROUP = "BBBBBBBBBB";

    @Autowired
    private InterestGroupRepository interestGroupRepository;

    @Autowired
    private InterestGroupMapper interestGroupMapper;

    @Autowired
    private InterestGroupService interestGroupService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restInterestGroupMockMvc;

    private InterestGroup interestGroup;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static InterestGroup createEntity(EntityManager em) {
        InterestGroup interestGroup = new InterestGroup()
            .interestGroup(DEFAULT_INTEREST_GROUP);
        return interestGroup;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static InterestGroup createUpdatedEntity(EntityManager em) {
        InterestGroup interestGroup = new InterestGroup()
            .interestGroup(UPDATED_INTEREST_GROUP);
        return interestGroup;
    }

    @BeforeEach
    public void initTest() {
        interestGroup = createEntity(em);
    }

    @Test
    @Transactional
    public void createInterestGroup() throws Exception {
        int databaseSizeBeforeCreate = interestGroupRepository.findAll().size();
        // Create the InterestGroup
        InterestGroupDTO interestGroupDTO = interestGroupMapper.toDto(interestGroup);
        restInterestGroupMockMvc.perform(post("/api/interest-groups")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(interestGroupDTO)))
            .andExpect(status().isCreated());

        // Validate the InterestGroup in the database
        List<InterestGroup> interestGroupList = interestGroupRepository.findAll();
        assertThat(interestGroupList).hasSize(databaseSizeBeforeCreate + 1);
        InterestGroup testInterestGroup = interestGroupList.get(interestGroupList.size() - 1);
        assertThat(testInterestGroup.getInterestGroup()).isEqualTo(DEFAULT_INTEREST_GROUP);
    }

    @Test
    @Transactional
    public void createInterestGroupWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = interestGroupRepository.findAll().size();

        // Create the InterestGroup with an existing ID
        interestGroup.setId(1L);
        InterestGroupDTO interestGroupDTO = interestGroupMapper.toDto(interestGroup);

        // An entity with an existing ID cannot be created, so this API call must fail
        restInterestGroupMockMvc.perform(post("/api/interest-groups")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(interestGroupDTO)))
            .andExpect(status().isBadRequest());

        // Validate the InterestGroup in the database
        List<InterestGroup> interestGroupList = interestGroupRepository.findAll();
        assertThat(interestGroupList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllInterestGroups() throws Exception {
        // Initialize the database
        interestGroupRepository.saveAndFlush(interestGroup);

        // Get all the interestGroupList
        restInterestGroupMockMvc.perform(get("/api/interest-groups?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(interestGroup.getId().intValue())))
            .andExpect(jsonPath("$.[*].interestGroup").value(hasItem(DEFAULT_INTEREST_GROUP)));
    }
    
    @Test
    @Transactional
    public void getInterestGroup() throws Exception {
        // Initialize the database
        interestGroupRepository.saveAndFlush(interestGroup);

        // Get the interestGroup
        restInterestGroupMockMvc.perform(get("/api/interest-groups/{id}", interestGroup.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(interestGroup.getId().intValue()))
            .andExpect(jsonPath("$.interestGroup").value(DEFAULT_INTEREST_GROUP));
    }
    @Test
    @Transactional
    public void getNonExistingInterestGroup() throws Exception {
        // Get the interestGroup
        restInterestGroupMockMvc.perform(get("/api/interest-groups/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateInterestGroup() throws Exception {
        // Initialize the database
        interestGroupRepository.saveAndFlush(interestGroup);

        int databaseSizeBeforeUpdate = interestGroupRepository.findAll().size();

        // Update the interestGroup
        InterestGroup updatedInterestGroup = interestGroupRepository.findById(interestGroup.getId()).get();
        // Disconnect from session so that the updates on updatedInterestGroup are not directly saved in db
        em.detach(updatedInterestGroup);
        updatedInterestGroup
            .interestGroup(UPDATED_INTEREST_GROUP);
        InterestGroupDTO interestGroupDTO = interestGroupMapper.toDto(updatedInterestGroup);

        restInterestGroupMockMvc.perform(put("/api/interest-groups")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(interestGroupDTO)))
            .andExpect(status().isOk());

        // Validate the InterestGroup in the database
        List<InterestGroup> interestGroupList = interestGroupRepository.findAll();
        assertThat(interestGroupList).hasSize(databaseSizeBeforeUpdate);
        InterestGroup testInterestGroup = interestGroupList.get(interestGroupList.size() - 1);
        assertThat(testInterestGroup.getInterestGroup()).isEqualTo(UPDATED_INTEREST_GROUP);
    }

    @Test
    @Transactional
    public void updateNonExistingInterestGroup() throws Exception {
        int databaseSizeBeforeUpdate = interestGroupRepository.findAll().size();

        // Create the InterestGroup
        InterestGroupDTO interestGroupDTO = interestGroupMapper.toDto(interestGroup);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restInterestGroupMockMvc.perform(put("/api/interest-groups")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(interestGroupDTO)))
            .andExpect(status().isBadRequest());

        // Validate the InterestGroup in the database
        List<InterestGroup> interestGroupList = interestGroupRepository.findAll();
        assertThat(interestGroupList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteInterestGroup() throws Exception {
        // Initialize the database
        interestGroupRepository.saveAndFlush(interestGroup);

        int databaseSizeBeforeDelete = interestGroupRepository.findAll().size();

        // Delete the interestGroup
        restInterestGroupMockMvc.perform(delete("/api/interest-groups/{id}", interestGroup.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<InterestGroup> interestGroupList = interestGroupRepository.findAll();
        assertThat(interestGroupList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
