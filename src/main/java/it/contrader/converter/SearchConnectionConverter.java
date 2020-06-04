package it.contrader.converter;
import org.springframework.stereotype.Component;

import it.contrader.dto.SearchConnectionDTO;
import it.contrader.model.SearchConnection;

@Component
public class SearchConnectionConverter extends AbstractConverter <SearchConnection, SearchConnectionDTO> {

	@Override
	public SearchConnection toEntity(SearchConnectionDTO searchConnectionDto) {
		SearchConnection searchConnection = null;
		if(searchConnectionDto != null) {
			searchConnection = new SearchConnection(searchConnectionDto.getIdDocument(), searchConnectionDto.getIdTag(), searchConnectionDto.getTag(), searchConnectionDto.getDocument());
		}
		return searchConnection;
	}

	@Override
	public SearchConnectionDTO toDTO(SearchConnection searchConnection) {
		
		SearchConnectionDTO searchConnectionDTO = null;
		if(searchConnection != null) {
			searchConnectionDTO = new SearchConnectionDTO(searchConnection.getIdDocument(), searchConnection.getIdTag(), searchConnection.getTag(), searchConnection.getDocument());
		}
		return searchConnectionDTO;
		
	}

}
