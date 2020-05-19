package it.contrader.controller;

import java.util.List;

import it.contrader.dto.DocumentDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.DocumentService;

public class DocumentController implements Controller {
	
	private static String sub_package = "Document";
	
	private DocumentService documentService;
	
	public DocumentController() {
		this.documentService = new DocumentService();
	}

	@Override
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");
		
		int id;
		String text;
		
		switch(mode) {

		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			DocumentDTO documentDTO = documentService.read(id);
			request.put("tags", documentDTO);
			MainDispatcher.getInstance().callView(sub_package + "DocumentRead", request);
			break;
		
		case "INSERT":
			text = request.get("text").toString();
			
			DocumentDTO docToInsert = new DocumentDTO(text);
			
			documentService.insert(docToInsert);
			
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "DocumentInsert", request);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			
			documentService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "DocumentDelete", request);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			text = request.get("text").toString();
			DocumentDTO documentDTOToUpdate = new DocumentDTO(text);
			documentDTOToUpdate.setIdDocument(id);
			documentService.update(documentDTOToUpdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "DocumentUpdate", request);
			break;
			
		case "DOCUMENTLIST":
			List<DocumentDTO> documentDTOList = documentService.getAll();
			request.put("documents", documentDTOList);
			MainDispatcher.getInstance().callView("Document", request);
			break;
			
		case "GETCHOICE":
			
			switch(choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "DocRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "DocInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "DocUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "DocDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);

		}
	}

}
