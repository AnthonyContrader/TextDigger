package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.DescriptionDTO;
import it.contrader.service.DescriptionService;

@Controller
@RequestMapping("/description")
public class DescriptionController {
	
	@Autowired
	private DescriptionService descriptionService;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
	setAll(request);
	return "descriptions";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("idDescription") Long idDescription) {
		descriptionService.delete(idDescription);
		setAll(request);
		return "descriptions";
	}
	
	@GetMapping("/preupdate")
	public String preupdate(HttpServletRequest request, @RequestParam("idDescription") Long idDescription) {
		request.getSession().setAttribute("dto", descriptionService.read(idDescription));
		return "updatedescription";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request , @RequestParam("idDescription") Long idDescription, @RequestParam ("description")
	String description) {
		DescriptionDTO descriptionDTO = new DescriptionDTO();
		descriptionDTO.setIdDescription(idDescription);
		descriptionDTO.setDescription(description);
		descriptionService.update(descriptionDTO);
		setAll(request);
		return "descriptions";
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("description") String description) {
		DescriptionDTO descriptionDTO = new DescriptionDTO();
		descriptionDTO.setDescription(description);
		descriptionService.insert(descriptionDTO);
		setAll(request);
		return "descriptions";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam ("idDescription") Long idDescription) {
		request.getSession().setAttribute("dto", descriptionService.read(idDescription));
		return "readdescription";
	}

	
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", descriptionService.getAll());
	}

}
