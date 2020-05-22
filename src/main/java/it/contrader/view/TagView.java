package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.TagDTO;
import it.contrader.main.MainDispatcher;

public class TagView extends AbstractView {
	
	private Request request;
	
	private String choice;
	
	public TagView() {
		
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione Tag ----------------\n");
			System.out.println("IDTag\tTag");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<TagDTO> Tags = (List<TagDTO>) request.get("tags");
			for (TagDTO t: Tags)
				System.out.println(t);
			System.out.println();
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();
	
}
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Tag", "doControl", this.request);
	}
}
