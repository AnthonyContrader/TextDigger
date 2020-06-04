package it.contrader.dto;

import it.contrader.model.Description;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TagDTO {

	private Long id;

	private String tag;
	
	private Description description;

}
