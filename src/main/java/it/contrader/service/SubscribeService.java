package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.SubscribeConverter;
import it.contrader.dao.SubscribeRepository;
import it.contrader.dto.SubscribeDTO;
import it.contrader.model.Subscribe;

@Service
public class SubscribeService extends AbstractService<Subscribe, SubscribeDTO> {
	
	@Autowired
	private SubscribeConverter subscribeConverter;
	
	@Autowired
	private SubscribeRepository subscribeRepository;


}
