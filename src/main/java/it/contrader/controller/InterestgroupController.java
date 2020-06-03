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

@Controller
@RequestMapping("/interestgroup")
public class InterestgroupController {

	@Autowired
	private InterestgroupService service;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "interestgroups";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "interestgroups";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateinterestgroup";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("interestgroup") String interestgroup) {

		InterestgroupDTO dto = new InterestgroupDTO();
		dto.setId(id);
		dto.setInterestgroup(interestgroup);
		service.update(dto);
		setAll(request);
		return "interestgroups";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("interestgroup") String interestgroup) {
		InterestgroupDTO dto = new InterestgroupDTO();
		dto.setInterestgroup(interestgroup);
		service.insert(dto);
		setAll(request);
		return "interestgroups";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readinterestgroup";
	}


	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
