package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.LibraryDTO;
import it.contrader.model.Description;
import it.contrader.model.Interest;
import it.contrader.service.DescriptionService;
import it.contrader.service.InterestService;
import it.contrader.service.LibraryService;

@RestController
@RequestMapping("/library")
@CrossOrigin(origins = "http://localhost:4200")
public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;
	
	@Autowired
	private DescriptionService descriptionService;
	
	@Autowired
	private InterestService interestService;
	
}
