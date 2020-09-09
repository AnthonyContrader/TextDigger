package com.contrader.textdigger.service;

import com.contrader.textdigger.service.dto.InterestDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.contrader.textdigger.domain.Interest}.
 */
public interface InterestService {

    /**
     * Save a interest.
     *
     * @param interestDTO the entity to save.
     * @return the persisted entity.
     */
    InterestDTO save(InterestDTO interestDTO);

    /**
     * Get all the interests.
     *
     * @return the list of entities.
     */
    List<InterestDTO> findAll();


    /**
     * Get the "id" interest.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<InterestDTO> findOne(Long id);

    /**
     * Delete the "id" interest.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
