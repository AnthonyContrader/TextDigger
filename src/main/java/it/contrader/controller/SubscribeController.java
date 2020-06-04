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
		return "name";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("idSubscribe") Long idSubscribe) {
		subscribeService.delete(idSubscribe);
		setAll(request);
		return "subscribes";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("idSubscribe") Long idSubscribe) {
		request.getSession().setAttribute("dto", subscribeService.read(idSubscribe));
		return "updatesubscribe";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("idSubscribe") Long idSubscribe, @RequestParam("name") String name) {

		SubscribeDTO dto = new SubscribeDTO();
		dto.setIdSubscribe(idSubscribe);
		dto.setName(name);
		subscribeService.update(dto);
		setAll(request);
		return "subscribes";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("name") String name) {
		SubscribeDTO dto = new SubscribeDTO();
		dto.setName(name);
		subscribeService.insert(dto);
		setAll(request);
		return "subscribes";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("idSubscribe") Long idSubscribe) {
		request.getSession().setAttribute("dto", subscribeService.read(idSubscribe));
		return "readfolder";
	}


	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", subscribeService.getAll());
	}

}
