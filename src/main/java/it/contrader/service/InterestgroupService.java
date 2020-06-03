package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.InterestgroupConverter;
import it.contrader.dao.InterestgroupRepository;
import it.contrader.dto.InterestgroupDTO;
import it.contrader.model.Interestgroup;

@Service
public class InterestgroupService extends AbstractService<Interestgroup, InterestgroupDTO> {

	@Autowired
	private InterestgroupConverter converter;
	@Autowired
	private InterestgroupRepository repository;

	public InterestgroupDTO findByInterestgroup(String interestgroup) {
		return converter.toDTO(repository.findByInterestgroup(interestgroup));
	}

}
