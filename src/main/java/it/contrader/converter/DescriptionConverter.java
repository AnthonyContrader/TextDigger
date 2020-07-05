package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.DescriptionDTO;
import it.contrader.model.Description;

@Component
public class DescriptionConverter extends AbstractConverter<Description, DescriptionDTO> {

	@Override
	public Description toEntity(DescriptionDTO descriptionDto) {
		Description description = null;
		if(descriptionDto != null) {
			description = new Description(descriptionDto.getId(), descriptionDto.getDescription(), descriptionDto.getFolder(),
					descriptionDto.getLibrary(), descriptionDto.getDocument(), descriptionDto.getInterest());
		}
		return description;
	}

	@Override
	public DescriptionDTO toDTO(Description description) {
		DescriptionDTO descriptionDTO = null;
		if(description != null) {
			descriptionDTO = new DescriptionDTO(description.getId(), description.getDescription(), description.getFolder(),
					description.getLibrary(), description.getDocument(), description.getInterest());
		}
		return descriptionDTO;
	}

}
