package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.DescriptionRepository;
import it.contrader.dto.DescriptionDTO;
import it.contrader.model.Description;

@Service
public class DescriptionService extends AbstractService<Description, DescriptionDTO>{
	
	public DescriptionDTO findDescriptionByDescription(String description) {
		return converter.toDTO(((DescriptionRepository)repository).findDescriptionByDescription(description));
	}

}
