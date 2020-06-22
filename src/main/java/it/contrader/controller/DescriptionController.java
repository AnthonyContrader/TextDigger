package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.DescriptionDTO;
import it.contrader.model.Document;
import it.contrader.model.Folder;
import it.contrader.model.Interest;
import it.contrader.model.Library;
import it.contrader.service.DescriptionService;

@Controller
@RequestMapping("/description")
public class DescriptionController {
	
	@Autowired
	private DescriptionService descriptionService;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
	setAll(request);
	return "/description/descriptions";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		descriptionService.delete(id);
		setAll(request);
		return "/description/descriptions";
	}
	
	@GetMapping("/preupdate")
	public String preupdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", descriptionService.read(id));
		return "/description/updatedescription";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request , @RequestParam("id") Long id, @RequestParam ("description")
	String description, @RequestParam("folder") Folder folder, @RequestParam("library") Library library, 
	@RequestParam("document") Document document, @RequestParam("interest") Interest interest) {
		DescriptionDTO descriptionDTO = new DescriptionDTO();
		descriptionDTO.setId(id);
		descriptionDTO.setDescription(description);
		descriptionDTO.setInterest(interest);
		descriptionDTO.setFolder(folder);
		descriptionDTO.setLibrary(library);
		descriptionDTO.setDocument(document);
		descriptionService.update(descriptionDTO);
		setAll(request);
		return "/description/descriptions";
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("description") String description, @RequestParam("folder") Folder folder, @RequestParam("library") Library library, 
			@RequestParam("document") Document document, @RequestParam("interest") Interest interest) {
		DescriptionDTO descriptionDTO = new DescriptionDTO();
		descriptionDTO.setDescription(description);
		descriptionDTO.setInterest(interest);
		descriptionDTO.setFolder(folder);
		descriptionDTO.setLibrary(library);
		descriptionDTO.setDocument(document);
		descriptionService.insert(descriptionDTO);
		setAll(request);
		return "/description/descriptions";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam ("id") Long id) {
		request.getSession().setAttribute("dto", descriptionService.read(id));
		return "/description/readdescription";
	}

	
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", descriptionService.getAll());
	}

}
