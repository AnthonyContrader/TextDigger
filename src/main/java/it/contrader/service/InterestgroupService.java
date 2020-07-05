package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.InterestgroupRepository;
import it.contrader.dto.InterestgroupDTO;
import it.contrader.model.Interestgroup;

@Service
public class InterestgroupService extends AbstractService<Interestgroup, InterestgroupDTO> {

	public InterestgroupDTO findByInterestgroup(String interestgroup) {
		return converter.toDTO(((InterestgroupRepository)repository).findByInterestgroup(interestgroup));
	}
	
}
