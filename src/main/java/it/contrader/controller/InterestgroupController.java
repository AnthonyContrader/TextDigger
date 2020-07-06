package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.InterestgroupDTO;
import it.contrader.service.InterestgroupService;
import it.contrader.service.InterestService;

@RestController
@RequestMapping("/interestgroup")
@CrossOrigin(origins = "http://localhost:4200")
public class InterestgroupController extends AbstractController<InterestgroupDTO> {

	@Autowired
	private InterestgroupService service;
	
	@Autowired
	private InterestService serviceInterest;
	
}
