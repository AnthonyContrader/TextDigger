package it.contrader.view.tag;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class TagInsertView extends AbstractView{
	
	private Request request;
	
	private String tag;
	private final String mode = "INSERT";
	
	public TagInsertView() {
		
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Tag", null);
		}
		
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci il tag");
		tag = getInput();
		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("tag", tag);
		request.put("mode", "mode");
		MainDispatcher.getInstance().callAction("Tag", "doControl", request);
	}

}
