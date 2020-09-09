package com.contrader.textdigger.service.impl;

import com.contrader.textdigger.service.SearchConnectionService;
import com.contrader.textdigger.domain.SearchConnection;
import com.contrader.textdigger.repository.SearchConnectionRepository;
import com.contrader.textdigger.service.dto.SearchConnectionDTO;
import com.contrader.textdigger.service.mapper.SearchConnectionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link SearchConnection}.
 */
@Service
@Transactional
public class SearchConnectionServiceImpl implements SearchConnectionService {

    private final Logger log = LoggerFactory.getLogger(SearchConnectionServiceImpl.class);

    private final SearchConnectionRepository searchConnectionRepository;

    private final SearchConnectionMapper searchConnectionMapper;

    public SearchConnectionServiceImpl(SearchConnectionRepository searchConnectionRepository, SearchConnectionMapper searchConnectionMapper) {
        this.searchConnectionRepository = searchConnectionRepository;
        this.searchConnectionMapper = searchConnectionMapper;
    }

    @Override
    public SearchConnectionDTO save(SearchConnectionDTO searchConnectionDTO) {
        log.debug("Request to save SearchConnection : {}", searchConnectionDTO);
        SearchConnection searchConnection = searchConnectionMapper.toEntity(searchConnectionDTO);
        searchConnection = searchConnectionRepository.save(searchConnection);
        return searchConnectionMapper.toDto(searchConnection);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SearchConnectionDTO> findAll() {
        log.debug("Request to get all SearchConnections");
        return searchConnectionRepository.findAll().stream()
            .map(searchConnectionMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<SearchConnectionDTO> findOne(Long id) {
        log.debug("Request to get SearchConnection : {}", id);
        return searchConnectionRepository.findById(id)
            .map(searchConnectionMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete SearchConnection : {}", id);
        searchConnectionRepository.deleteById(id);
    }
}
