package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.FolderDTO;
import it.contrader.service.FolderService;

@Controller
@RequestMapping("/folder")
public class FolderController {
	
	@Autowired
	private FolderService folderService;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "interests";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		folderService.delete(id);
		setAll(request);
		return "folders";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", folderService.read(id));
		return "updatefolder";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name) {

		FolderDTO dto = new FolderDTO();
		dto.setIdFolder(id);
		dto.setName(name);
		folderService.update(dto);
		setAll(request);
		return "folders";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("name") String name) {
		FolderDTO dto = new FolderDTO();
		dto.setName(name);
		folderService.insert(dto);
		setAll(request);
		return "folders";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", folderService.read(id));
		return "readfolder";
	}


	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", folderService.getAll());
	}

}
