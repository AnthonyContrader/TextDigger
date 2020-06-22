package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.DocumentDTO;
import it.contrader.model.Description;
import it.contrader.model.Folder;
import it.contrader.model.User;
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
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		documentService.delete(id);
		setAll(request);
		return "/document/documents";
	}
	
	@GetMapping("/preupdate")
	public String preupdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", documentService.read(id));
		return "/document/updatedocument";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request , @RequestParam("id") Long id, @RequestParam ("text")
	String text, @RequestParam("user") User user,
	@RequestParam("folder") Folder folder, @RequestParam("description") Description description) {
		DocumentDTO documentDTO = new DocumentDTO();
		documentDTO.setId(id);
		documentDTO.setText(text);
		documentDTO.setUser(user);
		documentDTO.setFolder(folder);
		documentDTO.setDescription(description);
		documentService.update(documentDTO);
		setAll(request);
		return "/document/documents";
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("text") String text, @RequestParam("user") User user,
			@RequestParam("folder") Folder folder, @RequestParam("description") Description description) {
		DocumentDTO documentDTO = new DocumentDTO();
		documentDTO.setText(text);
		documentDTO.setUser(user);
		documentDTO.setFolder(folder);
		documentDTO.setDescription(description);
		documentService.insert(documentDTO);
		setAll(request);
		return "/document/documents";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam ("id") Long id) {
		request.getSession().setAttribute("dto", documentService.read(id));
		return "/document/readdocument";
	}

	
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", documentService.getAll());
	}
}

