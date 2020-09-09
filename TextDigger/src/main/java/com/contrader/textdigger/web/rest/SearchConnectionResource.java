package com.contrader.textdigger.web.rest;

import com.contrader.textdigger.service.SearchConnectionService;
import com.contrader.textdigger.web.rest.errors.BadRequestAlertException;
import com.contrader.textdigger.service.dto.SearchConnectionDTO;

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
 * REST controller for managing {@link com.contrader.textdigger.domain.SearchConnection}.
 */
@RestController
@RequestMapping("/api")
public class SearchConnectionResource {

    private final Logger log = LoggerFactory.getLogger(SearchConnectionResource.class);

    private static final String ENTITY_NAME = "textDiggerSearchConnection";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SearchConnectionService searchConnectionService;

    public SearchConnectionResource(SearchConnectionService searchConnectionService) {
        this.searchConnectionService = searchConnectionService;
    }

    /**
     * {@code POST  /search-connections} : Create a new searchConnection.
     *
     * @param searchConnectionDTO the searchConnectionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new searchConnectionDTO, or with status {@code 400 (Bad Request)} if the searchConnection has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/search-connections")
    public ResponseEntity<SearchConnectionDTO> createSearchConnection(@RequestBody SearchConnectionDTO searchConnectionDTO) throws URISyntaxException {
        log.debug("REST request to save SearchConnection : {}", searchConnectionDTO);
        if (searchConnectionDTO.getId() != null) {
            throw new BadRequestAlertException("A new searchConnection cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SearchConnectionDTO result = searchConnectionService.save(searchConnectionDTO);
        return ResponseEntity.created(new URI("/api/search-connections/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /search-connections} : Updates an existing searchConnection.
     *
     * @param searchConnectionDTO the searchConnectionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated searchConnectionDTO,
     * or with status {@code 400 (Bad Request)} if the searchConnectionDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the searchConnectionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/search-connections")
    public ResponseEntity<SearchConnectionDTO> updateSearchConnection(@RequestBody SearchConnectionDTO searchConnectionDTO) throws URISyntaxException {
        log.debug("REST request to update SearchConnection : {}", searchConnectionDTO);
        if (searchConnectionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SearchConnectionDTO result = searchConnectionService.save(searchConnectionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, searchConnectionDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /search-connections} : get all the searchConnections.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of searchConnections in body.
     */
    @GetMapping("/search-connections")
    public List<SearchConnectionDTO> getAllSearchConnections() {
        log.debug("REST request to get all SearchConnections");
        return searchConnectionService.findAll();
    }

    /**
     * {@code GET  /search-connections/:id} : get the "id" searchConnection.
     *
     * @param id the id of the searchConnectionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the searchConnectionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/search-connections/{id}")
    public ResponseEntity<SearchConnectionDTO> getSearchConnection(@PathVariable Long id) {
        log.debug("REST request to get SearchConnection : {}", id);
        Optional<SearchConnectionDTO> searchConnectionDTO = searchConnectionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(searchConnectionDTO);
    }

    /**
     * {@code DELETE  /search-connections/:id} : delete the "id" searchConnection.
     *
     * @param id the id of the searchConnectionDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/search-connections/{id}")
    public ResponseEntity<Void> deleteSearchConnection(@PathVariable Long id) {
        log.debug("REST request to delete SearchConnection : {}", id);
        searchConnectionService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
