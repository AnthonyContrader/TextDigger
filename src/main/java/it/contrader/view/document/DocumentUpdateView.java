package it.contrader.view.document;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class DocumentUpdateView extends AbstractView {

    private Request request;
	
    private int idDocument;
	private String text;
	
	private final String mode = "UPDATE";
	
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
			System.out.println("Inserisci idDocument del documento:");
			idDocument = Integer.parseInt(getInput());
			System.out.println("Inserisci testo:");
			text = getInput();
			
		} catch (Exception e) {

		}
	}


	@Override
	public void submit() {
		request = new Request();
		request.put("id", idDocument);
		request.put("text", text);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Document", "doControl", request);
	}

}
