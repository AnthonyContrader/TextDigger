package it.contrader.service;

import java.util.List;

import it.contrader.converter.SearchConnectionsConverter;
import it.contrader.dao.SearchConnectionsDAO;
import it.contrader.dto.SearchConnectionsDTO;

public class SearchConnectionsService {
	private SearchConnectionsDAO searchConnectionsDAO;
	private SearchConnectionsConverter searchConnectionsConverter;
	
	public SearchConnectionsService() {
		this.searchConnectionsDAO = new SearchConnectionsDAO();
		this.searchConnectionsConverter = new SearchConnectionsConverter();
	}
	
	public List<SearchConnectionsDTO> getAll(){
		return searchConnectionsConverter.toDTOList(searchConnectionsDAO.getAll());
	}
}
