package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.SearchConnectionDTO;
import it.contrader.model.Document;
import it.contrader.model.Tag;
import it.contrader.service.DocumentService;
import it.contrader.service.SearchConnectionService;
import it.contrader.service.TagService;

@Controller
@RequestMapping("/searchconnection")
public class SearchConnectionController {
	
	@Autowired
	private SearchConnectionService searchconnectionService;
	
	@Autowired
	private TagService serviceTag;
	
	@Autowired
	private DocumentService serviceDocument;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
	setAll(request);
	return "searchconnection/searchconnections";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		searchconnectionService.delete(id);
		setAll(request);
		return "searchconnection/searchconnections";
	}
	
	@GetMapping("/preupdate")
	public String preupdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", searchconnectionService.read(id));
		return "searchconnection/updatesearchconnection";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request ,@RequestParam ("tag") Tag tag, @RequestParam("id") Long id, @RequestParam("document") Document document,
			@RequestParam ("text")String text) {
		SearchConnectionDTO searchConnectionDTO = new SearchConnectionDTO();
		searchConnectionDTO.setId(id);
		searchConnectionDTO.setTag(tag);
		searchConnectionDTO.setDocument(document);
		searchConnectionDTO.setText(text);
		searchconnectionService.update(searchConnectionDTO);
		setAll(request);
		return "searchconnection/searchconnections";
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request ,@RequestParam ("tag") Tag tag, @RequestParam("document") Document document, @RequestParam("text")String text) {
		SearchConnectionDTO searchConnectionDTO = new SearchConnectionDTO();
		searchConnectionDTO.setText(text);
		searchConnectionDTO.setTag(tag);
		searchConnectionDTO.setDocument(document);
		searchconnectionService.insert(searchConnectionDTO);
		setAll(request);
		return "searchconnection/searchconnections";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") int id) {
		request.getSession().setAttribute("dto", searchconnectionService.read(id));
		return "searchconnection/readsearchconnection";
	}

	
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", searchconnectionService.getAll());
		request.getSession().setAttribute("tags", serviceTag.getAll());
		request.getSession().setAttribute("documents",serviceDocument.getAll());
	}
}

