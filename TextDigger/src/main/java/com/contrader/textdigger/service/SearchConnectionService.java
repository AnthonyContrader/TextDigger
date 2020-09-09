package com.contrader.textdigger.service;

import com.contrader.textdigger.service.dto.SearchConnectionDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.contrader.textdigger.domain.SearchConnection}.
 */
public interface SearchConnectionService {

    /**
     * Save a searchConnection.
     *
     * @param searchConnectionDTO the entity to save.
     * @return the persisted entity.
     */
    SearchConnectionDTO save(SearchConnectionDTO searchConnectionDTO);

    /**
     * Get all the searchConnections.
     *
     * @return the list of entities.
     */
    List<SearchConnectionDTO> findAll();


    /**
     * Get the "id" searchConnection.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SearchConnectionDTO> findOne(Long id);

    /**
     * Delete the "id" searchConnection.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
