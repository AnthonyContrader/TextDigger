package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.DocumentDTO;
import it.contrader.service.DocumentService;

@Controller
@RequestMapping("/document")
public class DocumentController {
	
	@Autowired
	private DocumentService documentService;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
	setAll(request);
	return "/document/documents";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("idDocument") Long idDocument) {
		documentService.delete(idDocument);
		setAll(request);
		return "/document/documents";
	}
	
	@GetMapping("/preupdate")
	public String preupdate(HttpServletRequest request, @RequestParam("idDocument") Long idDocument) {
		request.getSession().setAttribute("dto", documentService.read(idDocument));
		return "/document/updatedocument";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request , @RequestParam("idDocument") Long idDocument, @RequestParam ("text")
	String text) {
		DocumentDTO documentDTO = new DocumentDTO();
		documentDTO.setIdDocument(idDocument);
		documentDTO.setText(text);
		documentService.update(documentDTO);
		setAll(request);
		return "/document/documents";
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("text") String text) {
		DocumentDTO documentDTO = new DocumentDTO();
		documentDTO.setText(text);
		documentService.insert(documentDTO);
		setAll(request);
		return "/document/documents";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam ("idDocument") Long idDocument) {
		request.getSession().setAttribute("dto", documentService.read(idDocument));
		return "/document/readdocument";
	}

	
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", documentService.getAll());
	}
}

