package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.SearchConnectionDTO;
import it.contrader.service.DocumentService;
import it.contrader.service.SearchConnectionService;
import it.contrader.service.TagService;

@RestController
@RequestMapping("/searchconnection")
@CrossOrigin(origins = "http://localhost:4200")
public class SearchConnectionController extends AbstractController<SearchConnectionDTO>{
	
	@Autowired
	private SearchConnectionService searchconnectionService;
	
	@Autowired
	private TagService serviceTag;
	
	@Autowired
	private DocumentService serviceDocument;
	
}

