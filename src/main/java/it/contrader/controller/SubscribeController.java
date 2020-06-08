package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.SubscribeDTO;
import it.contrader.service.SubscribeService;

@Controller
@RequestMapping("/subscribe")
public class SubscribeController {
	
	@Autowired
	private SubscribeService subscribeService;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "/subscribe/subscribes";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		subscribeService.delete(id);
		setAll(request);
		return "/subscribe/subscribes";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", subscribeService.read(id));
		return "/subscribe/updatesubscribe";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("subscribe") String name) {

		SubscribeDTO dto = new SubscribeDTO();
		dto.setId(id);
		dto.setName(name);
		subscribeService.update(dto);
		setAll(request);
		return "/subscribe/subscribes";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("subscribe") String name) {
		SubscribeDTO dto = new SubscribeDTO();
		dto.setName(name);
		subscribeService.insert(dto);
		setAll(request);
		return "/subscribe/subscribes";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", subscribeService.read(id));
		return "/subscribe/readsubscribe";
	}


	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", subscribeService.getAll());
	}

}
