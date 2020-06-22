package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.FolderDTO;
import it.contrader.model.Description;
import it.contrader.model.Library;
import it.contrader.service.FolderService;

@Controller
@RequestMapping("/folder")
public class FolderController {
	
	@Autowired
	private FolderService folderService;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "/folder/folders";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		folderService.delete(id);
		setAll(request);
		return "/folder/folders";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", folderService.read(id));
		return "/folder/updatefolder";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("library") Library library, @RequestParam("description") Description description) {

		FolderDTO dto = new FolderDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setLibrary(library);
		dto.setDescription(description);
		folderService.update(dto);
		setAll(request);
		return "/folder/folders";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("name") String name,
			@RequestParam("library") Library library, @RequestParam("description") Description description) {
		FolderDTO dto = new FolderDTO();
		dto.setName(name);
		folderService.insert(dto);
		dto.setLibrary(library);
		dto.setDescription(description);
		setAll(request);
		return "/folder/folders";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", folderService.read(id));
		return "/folder/readfolder";
	}


	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", folderService.getAll());
	}

}
