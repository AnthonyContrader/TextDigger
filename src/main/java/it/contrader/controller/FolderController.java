package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.FolderDTO;
import it.contrader.service.DescriptionService;
import it.contrader.service.FolderService;
import it.contrader.service.LibraryService;

@RestController
@RequestMapping("/folder")
@CrossOrigin(origins = "http://localhost:4200")
public class FolderController extends AbstractController<FolderDTO>{
	
	@Autowired
	private FolderService folderService;
	
	@Autowired
	private LibraryService libraryService;
	
	@Autowired
	private DescriptionService descriptionService;

}
