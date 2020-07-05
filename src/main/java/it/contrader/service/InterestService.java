package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.InterestRepository;
import it.contrader.dto.InterestDTO;
import it.contrader.model.Interest;

@Service
public class InterestService extends AbstractService<Interest, InterestDTO> {

	public InterestDTO findByInterest(String interest) {
		return converter.toDTO(((InterestRepository)repository).findByInterest(interest));
	}

}
