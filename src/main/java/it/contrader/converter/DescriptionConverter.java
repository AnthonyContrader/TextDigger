package it.contrader.converter;

import it.contrader.dto.DescriptionDTO;
import it.contrader.model.Description;

public class DescriptionConverter extends AbstractConverter<Description, DescriptionDTO> {

	@Override
	public Description toEntity(DescriptionDTO descriptionDto) {
		Description description = null;
		if(descriptionDto != null) {
			description = new Description(descriptionDto.getIdDescription(), descriptionDto.getDescription(), descriptionDto.getFolder(),
					descriptionDto.getLibrary(), descriptionDto.getDocument(), descriptionDto.getTags());
		}
		return description;
	}

	@Override
	public DescriptionDTO toDTO(Description description) {
		DescriptionDTO descriptionDTO = null;
		if(description != null) {
			descriptionDTO = new DescriptionDTO(description.getIdDescription(), description.getDescription(), description.getFolder(),
					description.getLibrary(), description.getDocument(), description.getTags());
		}
		return descriptionDTO;
	}

}
