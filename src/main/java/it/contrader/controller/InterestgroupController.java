package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.InterestgroupDTO;
import it.contrader.service.InterestgroupService;
import it.contrader.model.Interest;
import it.contrader.service.InterestService;

@Controller
@RequestMapping("/interestgroup")
public class InterestgroupController {

	@Autowired
	private InterestgroupService service;
	
	@Autowired
	private InterestService serviceInterest;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "/interestgroup/interestgroups";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "/interestgroup/interestgroups";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "/interestgroup/updateinterestgroup";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("interest") Interest interest, @RequestParam("id") Long id, @RequestParam("interestgroup") String interestgroup) {

		InterestgroupDTO dto = new InterestgroupDTO();
		dto.setId(id);
		dto.setInterestgroup(interestgroup);
		dto.setInterest(interest);
		service.update(dto);
		setAll(request);
		return "/interestgroup/interestgroups";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("interest") Interest interest, @RequestParam("interestgroup") String interestgroup) {
		InterestgroupDTO dto = new InterestgroupDTO();
		dto.setInterestgroup(interestgroup);
		dto.setInterest(interest);
		service.insert(dto);
		setAll(request);
		return "/interestgroup/interestgroups";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "/interestgroup/readinterestgroup";
	}


	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
		request.getSession().setAttribute("interests", serviceInterest.getAll());
	}
}
