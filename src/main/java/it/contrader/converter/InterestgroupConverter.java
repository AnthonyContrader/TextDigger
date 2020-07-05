package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.InterestgroupDTO;

import it.contrader.model.Interestgroup;

@Component
public class InterestgroupConverter extends AbstractConverter<Interestgroup, InterestgroupDTO> {

	@Override
	public Interestgroup toEntity(InterestgroupDTO interestgroupDTO) {
		Interestgroup interestgroup = null;
		if (interestgroupDTO != null) {
			interestgroup = new Interestgroup(interestgroupDTO.getId(), interestgroupDTO.getInterestgroup(), interestgroupDTO.getInterest());
		}
		return interestgroup;
	}

	@Override
	public InterestgroupDTO toDTO(Interestgroup interestgroup) {
		InterestgroupDTO interestgroupDTO = null;
		if (interestgroup != null) {
			interestgroupDTO = new InterestgroupDTO(interestgroup.getId(), interestgroup.getInterestgroup(), interestgroup.getInterest());

		}
		return interestgroupDTO;
	}
}