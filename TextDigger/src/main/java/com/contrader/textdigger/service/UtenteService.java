package com.contrader.textdigger.service;

import com.contrader.textdigger.service.dto.UtenteDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.contrader.textdigger.domain.Utente}.
 */
public interface UtenteService {

    /**
     * Save a utente.
     *
     * @param utenteDTO the entity to save.
     * @return the persisted entity.
     */
    UtenteDTO save(UtenteDTO utenteDTO);

    /**
     * Get all the utentes.
     *
     * @return the list of entities.
     */
    List<UtenteDTO> findAll();


    /**
     * Get the "id" utente.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<UtenteDTO> findOne(Long id);

    /**
     * Delete the "id" utente.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
