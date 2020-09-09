package com.contrader.textdigger.web.rest;

import com.contrader.textdigger.TextDiggerApp;
import com.contrader.textdigger.domain.Subscribe;
import com.contrader.textdigger.repository.SubscribeRepository;
import com.contrader.textdigger.service.SubscribeService;
import com.contrader.textdigger.service.dto.SubscribeDTO;
import com.contrader.textdigger.service.mapper.SubscribeMapper;

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
 * Integration tests for the {@link SubscribeResource} REST controller.
 */
@SpringBootTest(classes = TextDiggerApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class SubscribeResourceIT {

    @Autowired
    private SubscribeRepository subscribeRepository;

    @Autowired
    private SubscribeMapper subscribeMapper;

    @Autowired
    private SubscribeService subscribeService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSubscribeMockMvc;

    private Subscribe subscribe;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Subscribe createEntity(EntityManager em) {
        Subscribe subscribe = new Subscribe();
        return subscribe;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Subscribe createUpdatedEntity(EntityManager em) {
        Subscribe subscribe = new Subscribe();
        return subscribe;
    }

    @BeforeEach
    public void initTest() {
        subscribe = createEntity(em);
    }

    @Test
    @Transactional
    public void createSubscribe() throws Exception {
        int databaseSizeBeforeCreate = subscribeRepository.findAll().size();
        // Create the Subscribe
        SubscribeDTO subscribeDTO = subscribeMapper.toDto(subscribe);
        restSubscribeMockMvc.perform(post("/api/subscribes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(subscribeDTO)))
            .andExpect(status().isCreated());

        // Validate the Subscribe in the database
        List<Subscribe> subscribeList = subscribeRepository.findAll();
        assertThat(subscribeList).hasSize(databaseSizeBeforeCreate + 1);
        Subscribe testSubscribe = subscribeList.get(subscribeList.size() - 1);
    }

    @Test
    @Transactional
    public void createSubscribeWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = subscribeRepository.findAll().size();

        // Create the Subscribe with an existing ID
        subscribe.setId(1L);
        SubscribeDTO subscribeDTO = subscribeMapper.toDto(subscribe);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSubscribeMockMvc.perform(post("/api/subscribes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(subscribeDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Subscribe in the database
        List<Subscribe> subscribeList = subscribeRepository.findAll();
        assertThat(subscribeList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSubscribes() throws Exception {
        // Initialize the database
        subscribeRepository.saveAndFlush(subscribe);

        // Get all the subscribeList
        restSubscribeMockMvc.perform(get("/api/subscribes?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(subscribe.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getSubscribe() throws Exception {
        // Initialize the database
        subscribeRepository.saveAndFlush(subscribe);

        // Get the subscribe
        restSubscribeMockMvc.perform(get("/api/subscribes/{id}", subscribe.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(subscribe.getId().intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingSubscribe() throws Exception {
        // Get the subscribe
        restSubscribeMockMvc.perform(get("/api/subscribes/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSubscribe() throws Exception {
        // Initialize the database
        subscribeRepository.saveAndFlush(subscribe);

        int databaseSizeBeforeUpdate = subscribeRepository.findAll().size();

        // Update the subscribe
        Subscribe updatedSubscribe = subscribeRepository.findById(subscribe.getId()).get();
        // Disconnect from session so that the updates on updatedSubscribe are not directly saved in db
        em.detach(updatedSubscribe);
        SubscribeDTO subscribeDTO = subscribeMapper.toDto(updatedSubscribe);

        restSubscribeMockMvc.perform(put("/api/subscribes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(subscribeDTO)))
            .andExpect(status().isOk());

        // Validate the Subscribe in the database
        List<Subscribe> subscribeList = subscribeRepository.findAll();
        assertThat(subscribeList).hasSize(databaseSizeBeforeUpdate);
        Subscribe testSubscribe = subscribeList.get(subscribeList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingSubscribe() throws Exception {
        int databaseSizeBeforeUpdate = subscribeRepository.findAll().size();

        // Create the Subscribe
        SubscribeDTO subscribeDTO = subscribeMapper.toDto(subscribe);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSubscribeMockMvc.perform(put("/api/subscribes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(subscribeDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Subscribe in the database
        List<Subscribe> subscribeList = subscribeRepository.findAll();
        assertThat(subscribeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSubscribe() throws Exception {
        // Initialize the database
        subscribeRepository.saveAndFlush(subscribe);

        int databaseSizeBeforeDelete = subscribeRepository.findAll().size();

        // Delete the subscribe
        restSubscribeMockMvc.perform(delete("/api/subscribes/{id}", subscribe.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Subscribe> subscribeList = subscribeRepository.findAll();
        assertThat(subscribeList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
