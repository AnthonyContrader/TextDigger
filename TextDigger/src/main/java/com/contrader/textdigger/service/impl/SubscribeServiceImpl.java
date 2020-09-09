package com.contrader.textdigger.service.impl;

import com.contrader.textdigger.service.SubscribeService;
import com.contrader.textdigger.domain.Subscribe;
import com.contrader.textdigger.repository.SubscribeRepository;
import com.contrader.textdigger.service.dto.SubscribeDTO;
import com.contrader.textdigger.service.mapper.SubscribeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Subscribe}.
 */
@Service
@Transactional
public class SubscribeServiceImpl implements SubscribeService {

    private final Logger log = LoggerFactory.getLogger(SubscribeServiceImpl.class);

    private final SubscribeRepository subscribeRepository;

    private final SubscribeMapper subscribeMapper;

    public SubscribeServiceImpl(SubscribeRepository subscribeRepository, SubscribeMapper subscribeMapper) {
        this.subscribeRepository = subscribeRepository;
        this.subscribeMapper = subscribeMapper;
    }

    @Override
    public SubscribeDTO save(SubscribeDTO subscribeDTO) {
        log.debug("Request to save Subscribe : {}", subscribeDTO);
        Subscribe subscribe = subscribeMapper.toEntity(subscribeDTO);
        subscribe = subscribeRepository.save(subscribe);
        return subscribeMapper.toDto(subscribe);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubscribeDTO> findAll() {
        log.debug("Request to get all Subscribes");
        return subscribeRepository.findAll().stream()
            .map(subscribeMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<SubscribeDTO> findOne(Long id) {
        log.debug("Request to get Subscribe : {}", id);
        return subscribeRepository.findById(id)
            .map(subscribeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Subscribe : {}", id);
        subscribeRepository.deleteById(id);
    }
}
