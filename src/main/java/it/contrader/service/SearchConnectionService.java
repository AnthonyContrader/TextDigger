package it.contrader.service;

import it.contrader.converter.SearchConnectionConverter;
import it.contrader.dao.SearchConnectionDAO;
import it.contrader.dto.SearchConnectionDTO;
import it.contrader.model.SearchConnection;

public class SearchConnectionService extends AbstractService<SearchConnection, SearchConnectionDTO>{
	
	public SearchConnectionService(){
		this.dao = new SearchConnectionDAO();
		this.converter = new SearchConnectionConverter();

}
}