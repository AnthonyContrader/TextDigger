package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.InterestDTO;

import it.contrader.model.Interest;

@Component
public class InterestConverter extends AbstractConverter<Interest, InterestDTO> {

	@Override
	public Interest toEntity(InterestDTO interestDTO) {
		Interest interest = null;
		if (interestDTO != null) {
			interest = new Interest(interestDTO.getId(), interestDTO.getInterest(), interestDTO.getInterestgroup(), interestDTO.getDescription(), interestDTO.getLibrary());
		}
		return interest;
	}

	@Override
	public InterestDTO toDTO(Interest interest) {
		InterestDTO interestDTO = null;
		if (interest != null) {
			interestDTO = new InterestDTO(interest.getId(), interest.getInterest(), interestDTO.getInterestgroup(), interestDTO.getDescription(), interestDTO.getLibrary());

		}
		return interestDTO;
	}
}