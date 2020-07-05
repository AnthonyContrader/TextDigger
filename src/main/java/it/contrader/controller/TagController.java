package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.TagDTO;
import it.contrader.service.TagService;
import it.contrader.model.Description;
import it.contrader.service.DescriptionService;

@RestController
@RequestMapping("/tag")
@CrossOrigin(origins = "http://localhost:4200")
public class TagController {

	@Autowired
	private TagService service;
	
	@Autowired
	private DescriptionService serviceDescription;

}
