package com.contrader.textdigger.service;

import com.contrader.textdigger.service.dto.InterestGroupDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.contrader.textdigger.domain.InterestGroup}.
 */
public interface InterestGroupService {

    /**
     * Save a interestGroup.
     *
     * @param interestGroupDTO the entity to save.
     * @return the persisted entity.
     */
    InterestGroupDTO save(InterestGroupDTO interestGroupDTO);

    /**
     * Get all the interestGroups.
     *
     * @return the list of entities.
     */
    List<InterestGroupDTO> findAll();


    /**
     * Get the "id" interestGroup.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<InterestGroupDTO> findOne(Long id);

    /**
     * Delete the "id" interestGroup.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
