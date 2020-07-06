package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.SubscribeDTO;
import it.contrader.service.InterestgroupService;
import it.contrader.service.SubscribeService;
import it.contrader.service.UserService;

@RestController
@RequestMapping("/subscribe")
@CrossOrigin(origins = "http://localhost:4200")
public class SubscribeController extends AbstractController<SubscribeDTO>{
	
	@Autowired
	private SubscribeService subscribeService;
	
	@Autowired
	private UserService serviceUser;
	
	@Autowired
	private InterestgroupService serviceInterestgroup;
	
}
