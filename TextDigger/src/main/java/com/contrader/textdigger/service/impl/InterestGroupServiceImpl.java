package com.contrader.textdigger.service.impl;

import com.contrader.textdigger.service.InterestGroupService;
import com.contrader.textdigger.domain.InterestGroup;
import com.contrader.textdigger.repository.InterestGroupRepository;
import com.contrader.textdigger.service.dto.InterestGroupDTO;
import com.contrader.textdigger.service.mapper.InterestGroupMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link InterestGroup}.
 */
@Service
@Transactional
public class InterestGroupServiceImpl implements InterestGroupService {

    private final Logger log = LoggerFactory.getLogger(InterestGroupServiceImpl.class);

    private final InterestGroupRepository interestGroupRepository;

    private final InterestGroupMapper interestGroupMapper;

    public InterestGroupServiceImpl(InterestGroupRepository interestGroupRepository, InterestGroupMapper interestGroupMapper) {
        this.interestGroupRepository = interestGroupRepository;
        this.interestGroupMapper = interestGroupMapper;
    }

    @Override
    public InterestGroupDTO save(InterestGroupDTO interestGroupDTO) {
        log.debug("Request to save InterestGroup : {}", interestGroupDTO);
        InterestGroup interestGroup = interestGroupMapper.toEntity(interestGroupDTO);
        interestGroup = interestGroupRepository.save(interestGroup);
        return interestGroupMapper.toDto(interestGroup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InterestGroupDTO> findAll() {
        log.debug("Request to get all InterestGroups");
        return interestGroupRepository.findAll().stream()
            .map(interestGroupMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<InterestGroupDTO> findOne(Long id) {
        log.debug("Request to get InterestGroup : {}", id);
        return interestGroupRepository.findById(id)
            .map(interestGroupMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete InterestGroup : {}", id);
        interestGroupRepository.deleteById(id);
    }
}
