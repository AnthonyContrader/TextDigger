package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.SearchConnectionConverter;
import it.contrader.dao.SearchConnectionRepository;
import it.contrader.dto.SearchConnectionDTO;
import it.contrader.model.SearchConnection;;

@Service
public class SearchConnectionService extends AbstractService<SearchConnection, SearchConnectionDTO> {
	
	@Autowired
	SearchConnectionConverter converter;
	
	@Autowired
	SearchConnectionRepository repository;
	
	public SearchConnectionDTO findByIdSearchConnection(Long idSearchConnection) {
		return converter.toDTO(repository.findByIdSearchConnection(idSearchConnection));
	}

}