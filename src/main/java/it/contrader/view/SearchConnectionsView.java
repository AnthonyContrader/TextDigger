package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.SearchConnectionsDTO;
import it.contrader.main.MainDispatcher;

public class SearchConnectionsView extends AbstractView {
	
	private Request request;
	private String choice;
	
	public SearchConnectionsView() {
		
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione Search Connections ----------------\n");
			System.out.println("idDocument\\idTags");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<SearchConnectionsDTO> Connections = (List<SearchConnectionsDTO>) request.get("searchconnections");
			for (SearchConnectionsDTO c: Connections)
				System.out.println(c);
			System.out.println();
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [B]ack [E]sci");

		this.choice = getInput();
	
}
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Connections", "doControl", this.request);
	}
}

