package it.contrader.view.document;

import it.contrader.controller.Request;

import it.contrader.dto.DocumentDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class DocumentReadView extends AbstractView{
	
	private Request request;
	
	private int idDocument;
	
	private final String mode = "READ";
	
	public DocumentReadView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			DocumentDTO Document = (DocumentDTO) request.get("document");
			System.out.println(Document);
			MainDispatcher.getInstance().callView("Document", null);
		}
	}

	
	
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'idDocument del documento:");
		idDocument = Integer.parseInt(getInput());
	}

	
	@Override
	public void submit() {
		request = new Request();
		request.put("iddocument", idDocument);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Document", "doControl", request);
	}

}


