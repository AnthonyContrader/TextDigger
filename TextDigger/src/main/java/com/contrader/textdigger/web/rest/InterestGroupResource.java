package com.contrader.textdigger.web.rest;

import com.contrader.textdigger.service.InterestGroupService;
import com.contrader.textdigger.web.rest.errors.BadRequestAlertException;
import com.contrader.textdigger.service.dto.InterestGroupDTO;

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
 * REST controller for managing {@link com.contrader.textdigger.domain.InterestGroup}.
 */
@RestController
@RequestMapping("/api")
public class InterestGroupResource {

    private final Logger log = LoggerFactory.getLogger(InterestGroupResource.class);

    private static final String ENTITY_NAME = "textDiggerInterestGroup";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final InterestGroupService interestGroupService;

    public InterestGroupResource(InterestGroupService interestGroupService) {
        this.interestGroupService = interestGroupService;
    }

    /**
     * {@code POST  /interest-groups} : Create a new interestGroup.
     *
     * @param interestGroupDTO the interestGroupDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new interestGroupDTO, or with status {@code 400 (Bad Request)} if the interestGroup has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/interest-groups")
    public ResponseEntity<InterestGroupDTO> createInterestGroup(@RequestBody InterestGroupDTO interestGroupDTO) throws URISyntaxException {
        log.debug("REST request to save InterestGroup : {}", interestGroupDTO);
        if (interestGroupDTO.getId() != null) {
            throw new BadRequestAlertException("A new interestGroup cannot already have an ID", ENTITY_NAME, "idexists");
        }
        InterestGroupDTO result = interestGroupService.save(interestGroupDTO);
        return ResponseEntity.created(new URI("/api/interest-groups/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /interest-groups} : Updates an existing interestGroup.
     *
     * @param interestGroupDTO the interestGroupDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated interestGroupDTO,
     * or with status {@code 400 (Bad Request)} if the interestGroupDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the interestGroupDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/interest-groups")
    public ResponseEntity<InterestGroupDTO> updateInterestGroup(@RequestBody InterestGroupDTO interestGroupDTO) throws URISyntaxException {
        log.debug("REST request to update InterestGroup : {}", interestGroupDTO);
        if (interestGroupDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        InterestGroupDTO result = interestGroupService.save(interestGroupDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, interestGroupDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /interest-groups} : get all the interestGroups.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of interestGroups in body.
     */
    @GetMapping("/interest-groups")
    public List<InterestGroupDTO> getAllInterestGroups() {
        log.debug("REST request to get all InterestGroups");
        return interestGroupService.findAll();
    }

    /**
     * {@code GET  /interest-groups/:id} : get the "id" interestGroup.
     *
     * @param id the id of the interestGroupDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the interestGroupDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/interest-groups/{id}")
    public ResponseEntity<InterestGroupDTO> getInterestGroup(@PathVariable Long id) {
        log.debug("REST request to get InterestGroup : {}", id);
        Optional<InterestGroupDTO> interestGroupDTO = interestGroupService.findOne(id);
        return ResponseUtil.wrapOrNotFound(interestGroupDTO);
    }

    /**
     * {@code DELETE  /interest-groups/:id} : delete the "id" interestGroup.
     *
     * @param id the id of the interestGroupDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/interest-groups/{id}")
    public ResponseEntity<Void> deleteInterestGroup(@PathVariable Long id) {
        log.debug("REST request to delete InterestGroup : {}", id);
        interestGroupService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
