package com.contrader.textdigger.service.impl;

import com.contrader.textdigger.service.UtenteService;
import com.contrader.textdigger.domain.Utente;
import com.contrader.textdigger.repository.UtenteRepository;
import com.contrader.textdigger.service.dto.UtenteDTO;
import com.contrader.textdigger.service.mapper.UtenteMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Utente}.
 */
@Service
@Transactional
public class UtenteServiceImpl implements UtenteService {

    private final Logger log = LoggerFactory.getLogger(UtenteServiceImpl.class);

    private final UtenteRepository utenteRepository;

    private final UtenteMapper utenteMapper;

    public UtenteServiceImpl(UtenteRepository utenteRepository, UtenteMapper utenteMapper) {
        this.utenteRepository = utenteRepository;
        this.utenteMapper = utenteMapper;
    }

    @Override
    public UtenteDTO save(UtenteDTO utenteDTO) {
        log.debug("Request to save Utente : {}", utenteDTO);
        Utente utente = utenteMapper.toEntity(utenteDTO);
        utente = utenteRepository.save(utente);
        return utenteMapper.toDto(utente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UtenteDTO> findAll() {
        log.debug("Request to get all Utentes");
        return utenteRepository.findAll().stream()
            .map(utenteMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<UtenteDTO> findOne(Long id) {
        log.debug("Request to get Utente : {}", id);
        return utenteRepository.findById(id)
            .map(utenteMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Utente : {}", id);
        utenteRepository.deleteById(id);
    }
}
