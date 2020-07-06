package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.LibraryDTO;
import it.contrader.service.DescriptionService;
import it.contrader.service.InterestService;
import it.contrader.service.LibraryService;

@RestController
@RequestMapping("/library")
@CrossOrigin(origins = "http://localhost:4200")
public class LibraryController extends AbstractController<LibraryDTO>{
	
	@Autowired
	private LibraryService libraryService;
	
	@Autowired
	private DescriptionService descriptionService;
	
	@Autowired
	private InterestService interestService;
	
}
