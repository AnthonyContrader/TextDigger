package it.contrader.dto;

import java.util.List;

import it.contrader.model.Description;
import it.contrader.model.Interestgroup;
import it.contrader.model.Library;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class InterestDTO {

	private Long id;

	private String interest;

	private List<Interestgroup> interestGroups;
	
	private Description description;
	
	private List<Library> libraries;
}
