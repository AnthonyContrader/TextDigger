package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.TagDTO;
import it.contrader.service.TagService;

@Controller
@RequestMapping("/tag")
public class TagController {

	@Autowired
	private TagService service;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "tags";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "tags";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatetag";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("tag") String tag) {

		TagDTO dto = new TagDTO();
		dto.setId(id);
		dto.setTag(tag);
		service.update(dto);
		setAll(request);
		return "tags";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("tag") String tag) {
		TagDTO dto = new TagDTO();
		dto.setTag(tag);
		service.insert(dto);
		setAll(request);
		return "tags";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readtag";
	}


	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
