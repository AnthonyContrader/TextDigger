package it.contrader.view.tag;

import it.contrader.controller.Request;
import it.contrader.dto.TagDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class TagReadView extends AbstractView {
	
	private Request request;
	private int idTag;
	private final String mode = "READ";
	
	public TagReadView() {
		
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			TagDTO tag = (TagDTO) request.get("tag");
			System.out.println(tag);
			MainDispatcher.getInstance().callView("Tag", null);
		}
		
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del tag:");
		idTag = Integer.parseInt(getInput());
		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("idtags", idTag);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Tag", "doControl", request);
		
	}

}
