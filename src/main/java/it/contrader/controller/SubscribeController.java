package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.SubscribeDTO;
import it.contrader.model.Interestgroup;
import it.contrader.model.User;
import it.contrader.service.InterestgroupService;
import it.contrader.service.SubscribeService;
import it.contrader.service.UserService;

@RestController
@RequestMapping("/subscribe")
@CrossOrigin(origins = "http://localhost:4200")
public class SubscribeController {
	
	@Autowired
	private SubscribeService subscribeService;
	
	@Autowired
	private UserService serviceUser;
	
	@Autowired
	private InterestgroupService serviceInterestgroup;
	
}
