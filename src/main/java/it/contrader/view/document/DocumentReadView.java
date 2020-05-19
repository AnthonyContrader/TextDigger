package it.contrader.view.document;

import it.contrader.controller.Request;

import it.contrader.dto.DocumentDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class DocumentReadView extends AbstractView{
	
	private Request request;
	
	private int idDocument;
	
	private final String mode = "Read";
	
	public DocumentReadView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			DocumentDTO Document = (DocumentDTO) request.get("Document");
			System.out.println(Document);
			MainDispatcher.getInstance().callView("Document", null);
		}
	}

	
	
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'idDocument dell'utente:");
		idDocument = Integer.parseInt(getInput());
	}

	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", idDocument);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Document", "doControl", request);
	}

}


