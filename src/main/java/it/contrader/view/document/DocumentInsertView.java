package it.contrader.view.document;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class DocumentInsertView extends AbstractView{

	private Request request;
	
	private String text;
	
	private final String mode = "INSERT";
	
	public DocumentInsertView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Document", null);
		}
	}

	
	@Override
	public void showOptions() {
		
			System.out.println("Inserisci testo del documento:");
			text = getInput();
			
	}

	
	@Override
	public void submit() {
		request = new Request();
		request.put("text", text);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Document", "doControl", request);
	}


}
