package com.contrader.textdigger.web.rest;

import com.contrader.textdigger.TextDiggerApp;
import com.contrader.textdigger.domain.Utente;
import com.contrader.textdigger.repository.UtenteRepository;
import com.contrader.textdigger.service.UtenteService;
import com.contrader.textdigger.service.dto.UtenteDTO;
import com.contrader.textdigger.service.mapper.UtenteMapper;

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

import com.contrader.textdigger.domain.enumeration.Usertype;
/**
 * Integration tests for the {@link UtenteResource} REST controller.
 */
@SpringBootTest(classes = TextDiggerApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class UtenteResourceIT {

    private static final String DEFAULT_USERNAME = "AAAAAAAAAA";
    private static final String UPDATED_USERNAME = "BBBBBBBBBB";

    private static final String DEFAULT_PASSWORD = "AAAAAAAAAA";
    private static final String UPDATED_PASSWORD = "BBBBBBBBBB";

    private static final Usertype DEFAULT_USERTYPE = Usertype.ADMIN;
    private static final Usertype UPDATED_USERTYPE = Usertype.USER;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private UtenteMapper utenteMapper;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restUtenteMockMvc;

    private Utente utente;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Utente createEntity(EntityManager em) {
        Utente utente = new Utente()
            .username(DEFAULT_USERNAME)
            .password(DEFAULT_PASSWORD)
            .usertype(DEFAULT_USERTYPE);
        return utente;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Utente createUpdatedEntity(EntityManager em) {
        Utente utente = new Utente()
            .username(UPDATED_USERNAME)
            .password(UPDATED_PASSWORD)
            .usertype(UPDATED_USERTYPE);
        return utente;
    }

    @BeforeEach
    public void initTest() {
        utente = createEntity(em);
    }

    @Test
    @Transactional
    public void createUtente() throws Exception {
        int databaseSizeBeforeCreate = utenteRepository.findAll().size();
        // Create the Utente
        UtenteDTO utenteDTO = utenteMapper.toDto(utente);
        restUtenteMockMvc.perform(post("/api/utentes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(utenteDTO)))
            .andExpect(status().isCreated());

        // Validate the Utente in the database
        List<Utente> utenteList = utenteRepository.findAll();
        assertThat(utenteList).hasSize(databaseSizeBeforeCreate + 1);
        Utente testUtente = utenteList.get(utenteList.size() - 1);
        assertThat(testUtente.getUsername()).isEqualTo(DEFAULT_USERNAME);
        assertThat(testUtente.getPassword()).isEqualTo(DEFAULT_PASSWORD);
        assertThat(testUtente.getUsertype()).isEqualTo(DEFAULT_USERTYPE);
    }

    @Test
    @Transactional
    public void createUtenteWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = utenteRepository.findAll().size();

        // Create the Utente with an existing ID
        utente.setId(1L);
        UtenteDTO utenteDTO = utenteMapper.toDto(utente);

        // An entity with an existing ID cannot be created, so this API call must fail
        restUtenteMockMvc.perform(post("/api/utentes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(utenteDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Utente in the database
        List<Utente> utenteList = utenteRepository.findAll();
        assertThat(utenteList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkPasswordIsRequired() throws Exception {
        int databaseSizeBeforeTest = utenteRepository.findAll().size();
        // set the field null
        utente.setPassword(null);

        // Create the Utente, which fails.
        UtenteDTO utenteDTO = utenteMapper.toDto(utente);


        restUtenteMockMvc.perform(post("/api/utentes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(utenteDTO)))
            .andExpect(status().isBadRequest());

        List<Utente> utenteList = utenteRepository.findAll();
        assertThat(utenteList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllUtentes() throws Exception {
        // Initialize the database
        utenteRepository.saveAndFlush(utente);

        // Get all the utenteList
        restUtenteMockMvc.perform(get("/api/utentes?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(utente.getId().intValue())))
            .andExpect(jsonPath("$.[*].username").value(hasItem(DEFAULT_USERNAME)))
            .andExpect(jsonPath("$.[*].password").value(hasItem(DEFAULT_PASSWORD)))
            .andExpect(jsonPath("$.[*].usertype").value(hasItem(DEFAULT_USERTYPE.toString())));
    }
    
    @Test
    @Transactional
    public void getUtente() throws Exception {
        // Initialize the database
        utenteRepository.saveAndFlush(utente);

        // Get the utente
        restUtenteMockMvc.perform(get("/api/utentes/{id}", utente.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(utente.getId().intValue()))
            .andExpect(jsonPath("$.username").value(DEFAULT_USERNAME))
            .andExpect(jsonPath("$.password").value(DEFAULT_PASSWORD))
            .andExpect(jsonPath("$.usertype").value(DEFAULT_USERTYPE.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingUtente() throws Exception {
        // Get the utente
        restUtenteMockMvc.perform(get("/api/utentes/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateUtente() throws Exception {
        // Initialize the database
        utenteRepository.saveAndFlush(utente);

        int databaseSizeBeforeUpdate = utenteRepository.findAll().size();

        // Update the utente
        Utente updatedUtente = utenteRepository.findById(utente.getId()).get();
        // Disconnect from session so that the updates on updatedUtente are not directly saved in db
        em.detach(updatedUtente);
        updatedUtente
            .username(UPDATED_USERNAME)
            .password(UPDATED_PASSWORD)
            .usertype(UPDATED_USERTYPE);
        UtenteDTO utenteDTO = utenteMapper.toDto(updatedUtente);

        restUtenteMockMvc.perform(put("/api/utentes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(utenteDTO)))
            .andExpect(status().isOk());

        // Validate the Utente in the database
        List<Utente> utenteList = utenteRepository.findAll();
        assertThat(utenteList).hasSize(databaseSizeBeforeUpdate);
        Utente testUtente = utenteList.get(utenteList.size() - 1);
        assertThat(testUtente.getUsername()).isEqualTo(UPDATED_USERNAME);
        assertThat(testUtente.getPassword()).isEqualTo(UPDATED_PASSWORD);
        assertThat(testUtente.getUsertype()).isEqualTo(UPDATED_USERTYPE);
    }

    @Test
    @Transactional
    public void updateNonExistingUtente() throws Exception {
        int databaseSizeBeforeUpdate = utenteRepository.findAll().size();

        // Create the Utente
        UtenteDTO utenteDTO = utenteMapper.toDto(utente);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restUtenteMockMvc.perform(put("/api/utentes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(utenteDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Utente in the database
        List<Utente> utenteList = utenteRepository.findAll();
        assertThat(utenteList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteUtente() throws Exception {
        // Initialize the database
        utenteRepository.saveAndFlush(utente);

        int databaseSizeBeforeDelete = utenteRepository.findAll().size();

        // Delete the utente
        restUtenteMockMvc.perform(delete("/api/utentes/{id}", utente.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Utente> utenteList = utenteRepository.findAll();
        assertThat(utenteList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
