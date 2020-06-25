package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.LibraryDTO;
import it.contrader.model.Description;
import it.contrader.model.Interest;
import it.contrader.service.DescriptionService;
import it.contrader.service.InterestService;
import it.contrader.service.LibraryService;

@Controller
@RequestMapping("/library")
public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;
	
	@Autowired
	private DescriptionService descriptionService;
	
	@Autowired
	private InterestService interestService;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "/library/libraries";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		libraryService.delete(id);
		setAll(request);
		return "/library/libraries";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", libraryService.read(id));
		return "/library/updatelibrary";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("description") Description description, @RequestParam("interest") Interest interest) {

		LibraryDTO dto = new LibraryDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setInterest(interest);
		dto.setDescription(description);
		libraryService.update(dto);
		setAll(request);
		return "/library/libraries";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("name") String name,
			@RequestParam("description") Description description, @RequestParam("interest") Interest interest) {
		LibraryDTO dto = new LibraryDTO();
		dto.setName(name);
		dto.setInterest(interest);
		dto.setDescription(description);
		libraryService.insert(dto);
		setAll(request);
		return "/library/libraries";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", libraryService.read(id));
		return "/library/readlibrary";
	}


	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", libraryService.getAll());
		request.getSession().setAttribute("descriptions", descriptionService.getAll());
		request.getSession().setAttribute("interests", interestService.getAll());
	}

}
