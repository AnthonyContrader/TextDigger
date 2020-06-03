package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.SearchConnectionDTO;
import it.contrader.service.SearchConnectionService;

@Controller
@RequestMapping("/searchconnection")
public class SearchConnectionController {
	
	@Autowired
	private SearchConnectionService searchconnectionService;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
	setAll(request);
	return "searchconnections";
	}
	
/*@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("idDocument") Long idDocument) {
		documentService.delete(idDocument);
		setAll(request);
		return "documents";
	}
	
	@GetMapping("/preupdate")
	public String preupdate(HttpServletRequest request, @RequestParam("idDocument") Long idDocument) {
		request.getSession().setAttribute("documentdto", documentService.read(idDocument));
		return "updatedocument";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request , @RequestParam("idDocument") Long idDocument, @RequestParam ("text")
	String text) {
		DocumentDTO documentDTO = new DocumentDTO();
		documentDTO.setIdDocument(idDocument);
		documentDTO.setText(text);
		documentService.update(documentDTO);
		setAll(request);
		return "documents";
	}*/
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("idTag") int  idTag, @RequestParam("idDocument") int idDocument) {
		SearchConnectionDTO searchConnectionDTO = new SearchConnectionDTO();
		searchConnectionDTO.setIdTag(idTag);
		searchconnectionService.insert(searchConnectionDTO);
		setAll(request);
		return "searchconnections";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("idTag") int  idTag, @RequestParam("idDocument") int idDocument) {
		request.getSession().setAttribute("searchconnectiondto", searchconnectionService.read(idDocument));
		return "readsearchconnection";
	}

	
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", searchconnectionService.getAll());
	}
}

