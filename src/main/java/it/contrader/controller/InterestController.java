package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.InterestDTO;
import it.contrader.service.InterestService;

@RestController
@RequestMapping("/interest")
@CrossOrigin(origins = "http://localhost:4200")
public class InterestController extends AbstractController<InterestDTO> {

	@Autowired
	private InterestService service;

}
