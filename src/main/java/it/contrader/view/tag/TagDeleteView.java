package it.contrader.view.tag;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class TagDeleteView extends AbstractView {
	
	private Request request;
	
	private int idTags;
	private final String mode = "DELETE";
	
	public TagDeleteView() {
		
	}

	public void showResults(Request request) {
		if(request != null) {
			System.out.println("Cancellazione andata a buon fine. \n");
			MainDispatcher.getInstance().callView("Tag", null);
		}
	}

	public void showOptions() {
		System.out.println("Inserisci IDTag del tag: ");
		idTags = Integer.parseInt(getInput());
		
	}

	public void submit() {
		request = new Request();
		request.put("idtags", idTags);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Tag", "doControl", request);
	}

}
