package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.DocumentDTO;
import it.contrader.service.DescriptionService;
import it.contrader.service.DocumentService;
import it.contrader.service.FolderService;
import it.contrader.service.UserService;

@RestController
@RequestMapping("/document")
@CrossOrigin(origins = "http://localhost:4200")
public class DocumentController extends AbstractController<DocumentDTO> {
	
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FolderService folderService;
	
	@Autowired
	private DescriptionService descriptionService;
	
}

