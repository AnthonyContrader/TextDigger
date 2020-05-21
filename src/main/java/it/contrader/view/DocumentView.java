package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.DocumentDTO;
import it.contrader.main.MainDispatcher;

public class DocumentView extends AbstractView {

	private Request request;
	private String choice;
	
	public DocumentView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione Document ----------------\n");
			System.out.println("IdDocument\tUsers\tText");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<DocumentDTO> Document = (List<DocumentDTO>) request.get("Document");
			for (DocumentDTO d: Document)
				System.out.println(d);
			System.out.println();
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();
	
}
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Document", "doControl", this.request);
	}
}
