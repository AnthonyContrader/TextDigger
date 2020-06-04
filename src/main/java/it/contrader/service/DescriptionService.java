package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.DescriptionConverter;
import it.contrader.dao.DescriptionRepository;
import it.contrader.dto.DescriptionDTO;
import it.contrader.model.Description;

@Service
public class DescriptionService extends AbstractService<Description, DescriptionDTO>{
	
	@Autowired
	private DescriptionRepository descriptionRepository;
	
	@Autowired
	private DescriptionConverter descriptionConverter;
	
	public DescriptionDTO findDescriptionByDescription(String description) {
		return descriptionConverter.toDTO(descriptionRepository.findDescriptionByDescription(description));
	}

}
