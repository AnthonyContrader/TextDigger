package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.SearchConnectionDTO;
import it.contrader.service.SearchConnectionService;

@Controller
@RequestMapping("/searchconnection")
public class SearchConnectionController {
	
	@Autowired
	private SearchConnectionService searchconnectionService;
	
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
		request.getSession().setAttribute("searhconnectiondto", searchconnectionService.read(id));
		return "searchconnection/updatesearchconnection";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request , @RequestParam("id") Long id) {
		SearchConnectionDTO searchConnectionDTO = new SearchConnectionDTO();
		searchConnectionDTO.setId(id);
		searchconnectionService.update(searchConnectionDTO);
		setAll(request);
		return "searchconnection/searchconnections";
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request,@RequestParam("id") Long id) {
		SearchConnectionDTO searchConnectionDTO = new SearchConnectionDTO();
		searchConnectionDTO.setId(id);
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
	}
}

