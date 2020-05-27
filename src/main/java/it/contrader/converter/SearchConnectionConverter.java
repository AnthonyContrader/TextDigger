package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.SearchConnectionDTO;
import it.contrader.model.SearchConnection;

public class SearchConnectionConverter implements Converter<SearchConnection, SearchConnectionDTO> {

	@Override
	public SearchConnectionDTO toDTO(SearchConnection searchConnection) {
		
		SearchConnectionDTO searchConnectionDTO = new SearchConnectionDTO(searchConnection.getIdTag(), searchConnection.getIdDocument());
		return searchConnectionDTO;
	}

	@Override
	public SearchConnection toEntity(SearchConnectionDTO searchConnectionDTO) {
		
		SearchConnection searchConnection = new SearchConnection(searchConnectionDTO.getIdTag(), searchConnectionDTO.getIdDocument());
		return searchConnection;
	}

	@Override
	public List<SearchConnectionDTO> toDTOList(List<SearchConnection> searchConnectionList) {
		
		List<SearchConnectionDTO> searchConnectionDTOList = new ArrayList<SearchConnectionDTO>();
		
		for(SearchConnection searchConnection : searchConnectionList) {
			
			searchConnectionDTOList.add(toDTO(searchConnection));
		}
		
		
		return searchConnectionDTOList;
	}

}
