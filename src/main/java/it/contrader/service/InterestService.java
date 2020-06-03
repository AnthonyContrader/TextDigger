package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.InterestConverter;
import it.contrader.dao.InterestRepository;
import it.contrader.dto.InterestDTO;
import it.contrader.model.Interest;

@Service
public class InterestService extends AbstractService<Interest, InterestDTO> {

	@Autowired
	private InterestConverter converter;
	@Autowired
	private InterestRepository repository;

	public InterestDTO findByInterest(String interest) {
		return converter.toDTO(repository.findByInterest(interest));
	}

}
