package com.contrader.textdigger.web.rest;

import com.contrader.textdigger.service.SubscribeService;
import com.contrader.textdigger.web.rest.errors.BadRequestAlertException;
import com.contrader.textdigger.service.dto.SubscribeDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.contrader.textdigger.domain.Subscribe}.
 */
@RestController
@RequestMapping("/api")
public class SubscribeResource {

    private final Logger log = LoggerFactory.getLogger(SubscribeResource.class);

    private static final String ENTITY_NAME = "textDiggerSubscribe";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SubscribeService subscribeService;

    public SubscribeResource(SubscribeService subscribeService) {
        this.subscribeService = subscribeService;
    }

    /**
     * {@code POST  /subscribes} : Create a new subscribe.
     *
     * @param subscribeDTO the subscribeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new subscribeDTO, or with status {@code 400 (Bad Request)} if the subscribe has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/subscribes")
    public ResponseEntity<SubscribeDTO> createSubscribe(@RequestBody SubscribeDTO subscribeDTO) throws URISyntaxException {
        log.debug("REST request to save Subscribe : {}", subscribeDTO);
        if (subscribeDTO.getId() != null) {
            throw new BadRequestAlertException("A new subscribe cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SubscribeDTO result = subscribeService.save(subscribeDTO);
        return ResponseEntity.created(new URI("/api/subscribes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /subscribes} : Updates an existing subscribe.
     *
     * @param subscribeDTO the subscribeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated subscribeDTO,
     * or with status {@code 400 (Bad Request)} if the subscribeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the subscribeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/subscribes")
    public ResponseEntity<SubscribeDTO> updateSubscribe(@RequestBody SubscribeDTO subscribeDTO) throws URISyntaxException {
        log.debug("REST request to update Subscribe : {}", subscribeDTO);
        if (subscribeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SubscribeDTO result = subscribeService.save(subscribeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, subscribeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /subscribes} : get all the subscribes.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of subscribes in body.
     */
    @GetMapping("/subscribes")
    public List<SubscribeDTO> getAllSubscribes() {
        log.debug("REST request to get all Subscribes");
        return subscribeService.findAll();
    }

    /**
     * {@code GET  /subscribes/:id} : get the "id" subscribe.
     *
     * @param id the id of the subscribeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the subscribeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/subscribes/{id}")
    public ResponseEntity<SubscribeDTO> getSubscribe(@PathVariable Long id) {
        log.debug("REST request to get Subscribe : {}", id);
        Optional<SubscribeDTO> subscribeDTO = subscribeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(subscribeDTO);
    }

    /**
     * {@code DELETE  /subscribes/:id} : delete the "id" subscribe.
     *
     * @param id the id of the subscribeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/subscribes/{id}")
    public ResponseEntity<Void> deleteSubscribe(@PathVariable Long id) {
        log.debug("REST request to delete Subscribe : {}", id);
        subscribeService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
