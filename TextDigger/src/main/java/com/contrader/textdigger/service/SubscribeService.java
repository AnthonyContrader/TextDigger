package com.contrader.textdigger.service;

import com.contrader.textdigger.service.dto.SubscribeDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.contrader.textdigger.domain.Subscribe}.
 */
public interface SubscribeService {

    /**
     * Save a subscribe.
     *
     * @param subscribeDTO the entity to save.
     * @return the persisted entity.
     */
    SubscribeDTO save(SubscribeDTO subscribeDTO);

    /**
     * Get all the subscribes.
     *
     * @return the list of entities.
     */
    List<SubscribeDTO> findAll();


    /**
     * Get the "id" subscribe.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SubscribeDTO> findOne(Long id);

    /**
     * Delete the "id" subscribe.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
