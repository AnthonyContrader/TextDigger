package com.contrader.textdigger.service.impl;

import com.contrader.textdigger.service.InterestService;
import com.contrader.textdigger.domain.Interest;
import com.contrader.textdigger.repository.InterestRepository;
import com.contrader.textdigger.service.dto.InterestDTO;
import com.contrader.textdigger.service.mapper.InterestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Interest}.
 */
@Service
@Transactional
public class InterestServiceImpl implements InterestService {

    private final Logger log = LoggerFactory.getLogger(InterestServiceImpl.class);

    private final InterestRepository interestRepository;

    private final InterestMapper interestMapper;

    public InterestServiceImpl(InterestRepository interestRepository, InterestMapper interestMapper) {
        this.interestRepository = interestRepository;
        this.interestMapper = interestMapper;
    }

    @Override
    public InterestDTO save(InterestDTO interestDTO) {
        log.debug("Request to save Interest : {}", interestDTO);
        Interest interest = interestMapper.toEntity(interestDTO);
        interest = interestRepository.save(interest);
        return interestMapper.toDto(interest);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InterestDTO> findAll() {
        log.debug("Request to get all Interests");
        return interestRepository.findAll().stream()
            .map(interestMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<InterestDTO> findOne(Long id) {
        log.debug("Request to get Interest : {}", id);
        return interestRepository.findById(id)
            .map(interestMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Interest : {}", id);
        interestRepository.deleteById(id);
    }
}
