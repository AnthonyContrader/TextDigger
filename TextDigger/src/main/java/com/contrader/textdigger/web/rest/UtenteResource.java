package com.contrader.textdigger.web.rest;

import com.contrader.textdigger.service.UtenteService;
import com.contrader.textdigger.web.rest.errors.BadRequestAlertException;
import com.contrader.textdigger.service.dto.UtenteDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.contrader.textdigger.domain.Utente}.
 */
@RestController
@RequestMapping("/api")
public class UtenteResource {

    private final Logger log = LoggerFactory.getLogger(UtenteResource.class);

    private static final String ENTITY_NAME = "textDiggerUtente";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final UtenteService utenteService;

    public UtenteResource(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    /**
     * {@code POST  /utentes} : Create a new utente.
     *
     * @param utenteDTO the utenteDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new utenteDTO, or with status {@code 400 (Bad Request)} if the utente has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/utentes")
    public ResponseEntity<UtenteDTO> createUtente(@Valid @RequestBody UtenteDTO utenteDTO) throws URISyntaxException {
        log.debug("REST request to save Utente : {}", utenteDTO);
        if (utenteDTO.getId() != null) {
            throw new BadRequestAlertException("A new utente cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UtenteDTO result = utenteService.save(utenteDTO);
        return ResponseEntity.created(new URI("/api/utentes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /utentes} : Updates an existing utente.
     *
     * @param utenteDTO the utenteDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated utenteDTO,
     * or with status {@code 400 (Bad Request)} if the utenteDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the utenteDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/utentes")
    public ResponseEntity<UtenteDTO> updateUtente(@Valid @RequestBody UtenteDTO utenteDTO) throws URISyntaxException {
        log.debug("REST request to update Utente : {}", utenteDTO);
        if (utenteDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UtenteDTO result = utenteService.save(utenteDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, utenteDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /utentes} : get all the utentes.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of utentes in body.
     */
    @GetMapping("/utentes")
    public List<UtenteDTO> getAllUtentes() {
        log.debug("REST request to get all Utentes");
        return utenteService.findAll();
    }

    /**
     * {@code GET  /utentes/:id} : get the "id" utente.
     *
     * @param id the id of the utenteDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the utenteDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/utentes/{id}")
    public ResponseEntity<UtenteDTO> getUtente(@PathVariable Long id) {
        log.debug("REST request to get Utente : {}", id);
        Optional<UtenteDTO> utenteDTO = utenteService.findOne(id);
        return ResponseUtil.wrapOrNotFound(utenteDTO);
    }

    /**
     * {@code DELETE  /utentes/:id} : delete the "id" utente.
     *
     * @param id the id of the utenteDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/utentes/{id}")
    public ResponseEntity<Void> deleteUtente(@PathVariable Long id) {
        log.debug("REST request to delete Utente : {}", id);
        utenteService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
