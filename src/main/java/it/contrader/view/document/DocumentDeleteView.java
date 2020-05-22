package it.contrader.view.document;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class DocumentDeleteView extends AbstractView {
	
	private Request request;

	private int idDocument;
	private final String mode = "DELETE";

	public DocumentDeleteView() {
		
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Document", null);
		}
	}

	
	@Override
	public void showOptions() {
			System.out.println("Inserisci id del documento:");
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


