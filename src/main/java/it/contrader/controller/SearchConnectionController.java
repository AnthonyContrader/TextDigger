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
	public String delete(HttpServletRequest request, @RequestParam("idDocument") Long idDocument) {
		searchconnectionService.delete(idDocument);
		setAll(request);
		return "searchconnection/searchconnections";
	}
	
	@GetMapping("/preupdate")
	public String preupdate(HttpServletRequest request, @RequestParam("idDocument") Long idDocument) {
		request.getSession().setAttribute("documentdto", searchconnectionService.read(idDocument));
		return "searchconnection/updatedocument";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request , @RequestParam("idDocument") Long idDocument) {
		SearchConnectionDTO searchConnectionDTO = new SearchConnectionDTO();
		searchConnectionDTO.setIdDocument(idDocument);
		searchconnectionService.update(searchConnectionDTO);
		setAll(request);
		return "searchconnection/searchconnections";
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("idTag") Long  idTag, @RequestParam("idDocument") Long idDocument) {
		SearchConnectionDTO searchConnectionDTO = new SearchConnectionDTO();
		searchConnectionDTO.setIdTag(idTag);
		searchconnectionService.insert(searchConnectionDTO);
		setAll(request);
		return "searchconnection/searchconnections";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("idTag") int  idTag, @RequestParam("idDocument") int idDocument) {
		request.getSession().setAttribute("searchconnectiondto", searchconnectionService.read(idDocument));
		return "searchconnection/readsearchconnection";
	}

	
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", searchconnectionService.getAll());
	}
}

