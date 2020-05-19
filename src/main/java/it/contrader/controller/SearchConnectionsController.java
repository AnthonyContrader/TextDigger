package it.contrader.controller;


import java.util.List;

import it.contrader.dto.SearchConnectionsDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.SearchConnectionsService;

public class SearchConnectionsController implements Controller {
	
	private static String sub_package = "SearchConnections";
	
	private SearchConnectionsService searchConnectionsService;
	
	public SearchConnectionsController() {
		this.searchConnectionsService = new SearchConnectionsService();
	}

	@Override
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");
		
		
		switch(mode) {

		case "SEARCHCONNECTIONSLIST":
			List<SearchConnectionsDTO> searchConnectionsDTOList =  searchConnectionsService.getAll();
			request.put("searchconnections", searchConnectionsDTOList);
			MainDispatcher.getInstance().callView(sub_package + "DocumentRead", request);
			break;
			
		case "GETCHOICE" :
			switch(choice.toUpperCase()) {

			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);

		}
	}
	
}	


