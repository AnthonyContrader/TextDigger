package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.InterestDTO;
import it.contrader.service.InterestService;

@Controller
@RequestMapping("/interest")
public class InterestController {

	@Autowired
	private InterestService service;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "/interest/interests";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "/interest/interests";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "/interest/updateinterest";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("interest") String interest) {

		InterestDTO dto = new InterestDTO();
		dto.setId(id);
		dto.setInterest(interest);
		service.update(dto);
		setAll(request);
		return "/interest/interests";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("interest") String interest) {
		InterestDTO dto = new InterestDTO();
		dto.setInterest(interest);
		service.insert(dto);
		setAll(request);
		return "/interest/interests";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "/interest/readinterest";
	}


	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
