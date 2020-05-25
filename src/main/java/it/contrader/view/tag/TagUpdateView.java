package it.contrader.view.tag;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class TagUpdateView extends AbstractView {
	
	private Request request;
	
	private int id;
	private String tag;
	private final String mode = "UPDATE";
	
	public TagUpdateView() {
		
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Tag", null);
		}
	}

	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci IDTag del tag:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci tag:");
			tag = getInput();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("tag", tag);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Tag", "doControl", request);
	}

}
