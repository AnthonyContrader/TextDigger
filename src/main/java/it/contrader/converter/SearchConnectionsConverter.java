package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.SearchConnectionsDTO;
import it.contrader.model.SearchConnections;

public class SearchConnectionsConverter {
	
	public SearchConnectionsDTO toDTO(SearchConnections searchConnections) {
		
		SearchConnectionsDTO searchConnectionsDTO = new SearchConnectionsDTO(searchConnections.getIdDocument(), searchConnections.getIdTags());
		
		return searchConnectionsDTO;
	}
	
	public SearchConnections toEntity(SearchConnectionsDTO searchConnectionsDTO) {
		SearchConnections searchConnections = new SearchConnections(searchConnectionsDTO.getIdDocument(), searchConnectionsDTO.getIdTags());
		
		return searchConnections;
	}
	
	public List<SearchConnectionsDTO> toDTOList(List<SearchConnections> searchList){
		List<SearchConnectionsDTO> searchConDTOList = new ArrayList<SearchConnectionsDTO>();
		
		for(SearchConnections connections : searchList) {
			searchConDTOList.add(toDTO(connections));
		}
		
		return searchConDTOList;
	}

}
