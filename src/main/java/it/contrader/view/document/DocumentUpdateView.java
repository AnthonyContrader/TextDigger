package it.contrader.view.document;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class DocumentUpdateView extends AbstractView {

    private Request request;
	
    private int idDocument;
	private String textBlob;
	
	private final String mode = "Update";
	
	public DocumentUpdateView() {
		
	}
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Document", null);
		}
	}

	
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci idDocument dell'utente:");
			idDocument = Integer.parseInt(getInput());
			System.out.println("Inserisci testo:");
			textBlob = getInput();
			
		} catch (Exception e) {

		}
	}


	@Override
	public void submit() {
		request = new Request();
		request.put("id", idDocument);
		request.put("Testo", textBlob);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Document", "doControl", request);
	}

}
