package com.contrader.textdigger.web.rest;

import com.contrader.textdigger.TextDiggerApp;
import com.contrader.textdigger.domain.SearchConnection;
import com.contrader.textdigger.repository.SearchConnectionRepository;
import com.contrader.textdigger.service.SearchConnectionService;
import com.contrader.textdigger.service.dto.SearchConnectionDTO;
import com.contrader.textdigger.service.mapper.SearchConnectionMapper;

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
 * Integration tests for the {@link SearchConnectionResource} REST controller.
 */
@SpringBootTest(classes = TextDiggerApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class SearchConnectionResourceIT {

    @Autowired
    private SearchConnectionRepository searchConnectionRepository;

    @Autowired
    private SearchConnectionMapper searchConnectionMapper;

    @Autowired
    private SearchConnectionService searchConnectionService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSearchConnectionMockMvc;

    private SearchConnection searchConnection;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SearchConnection createEntity(EntityManager em) {
        SearchConnection searchConnection = new SearchConnection();
        return searchConnection;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SearchConnection createUpdatedEntity(EntityManager em) {
        SearchConnection searchConnection = new SearchConnection();
        return searchConnection;
    }

    @BeforeEach
    public void initTest() {
        searchConnection = createEntity(em);
    }

    @Test
    @Transactional
    public void createSearchConnection() throws Exception {
        int databaseSizeBeforeCreate = searchConnectionRepository.findAll().size();
        // Create the SearchConnection
        SearchConnectionDTO searchConnectionDTO = searchConnectionMapper.toDto(searchConnection);
        restSearchConnectionMockMvc.perform(post("/api/search-connections")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(searchConnectionDTO)))
            .andExpect(status().isCreated());

        // Validate the SearchConnection in the database
        List<SearchConnection> searchConnectionList = searchConnectionRepository.findAll();
        assertThat(searchConnectionList).hasSize(databaseSizeBeforeCreate + 1);
        SearchConnection testSearchConnection = searchConnectionList.get(searchConnectionList.size() - 1);
    }

    @Test
    @Transactional
    public void createSearchConnectionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = searchConnectionRepository.findAll().size();

        // Create the SearchConnection with an existing ID
        searchConnection.setId(1L);
        SearchConnectionDTO searchConnectionDTO = searchConnectionMapper.toDto(searchConnection);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSearchConnectionMockMvc.perform(post("/api/search-connections")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(searchConnectionDTO)))
            .andExpect(status().isBadRequest());

        // Validate the SearchConnection in the database
        List<SearchConnection> searchConnectionList = searchConnectionRepository.findAll();
        assertThat(searchConnectionList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSearchConnections() throws Exception {
        // Initialize the database
        searchConnectionRepository.saveAndFlush(searchConnection);

        // Get all the searchConnectionList
        restSearchConnectionMockMvc.perform(get("/api/search-connections?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(searchConnection.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getSearchConnection() throws Exception {
        // Initialize the database
        searchConnectionRepository.saveAndFlush(searchConnection);

        // Get the searchConnection
        restSearchConnectionMockMvc.perform(get("/api/search-connections/{id}", searchConnection.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(searchConnection.getId().intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingSearchConnection() throws Exception {
        // Get the searchConnection
        restSearchConnectionMockMvc.perform(get("/api/search-connections/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSearchConnection() throws Exception {
        // Initialize the database
        searchConnectionRepository.saveAndFlush(searchConnection);

        int databaseSizeBeforeUpdate = searchConnectionRepository.findAll().size();

        // Update the searchConnection
        SearchConnection updatedSearchConnection = searchConnectionRepository.findById(searchConnection.getId()).get();
        // Disconnect from session so that the updates on updatedSearchConnection are not directly saved in db
        em.detach(updatedSearchConnection);
        SearchConnectionDTO searchConnectionDTO = searchConnectionMapper.toDto(updatedSearchConnection);

        restSearchConnectionMockMvc.perform(put("/api/search-connections")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(searchConnectionDTO)))
            .andExpect(status().isOk());

        // Validate the SearchConnection in the database
        List<SearchConnection> searchConnectionList = searchConnectionRepository.findAll();
        assertThat(searchConnectionList).hasSize(databaseSizeBeforeUpdate);
        SearchConnection testSearchConnection = searchConnectionList.get(searchConnectionList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingSearchConnection() throws Exception {
        int databaseSizeBeforeUpdate = searchConnectionRepository.findAll().size();

        // Create the SearchConnection
        SearchConnectionDTO searchConnectionDTO = searchConnectionMapper.toDto(searchConnection);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSearchConnectionMockMvc.perform(put("/api/search-connections")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(searchConnectionDTO)))
            .andExpect(status().isBadRequest());

        // Validate the SearchConnection in the database
        List<SearchConnection> searchConnectionList = searchConnectionRepository.findAll();
        assertThat(searchConnectionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSearchConnection() throws Exception {
        // Initialize the database
        searchConnectionRepository.saveAndFlush(searchConnection);

        int databaseSizeBeforeDelete = searchConnectionRepository.findAll().size();

        // Delete the searchConnection
        restSearchConnectionMockMvc.perform(delete("/api/search-connections/{id}", searchConnection.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SearchConnection> searchConnectionList = searchConnectionRepository.findAll();
        assertThat(searchConnectionList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
