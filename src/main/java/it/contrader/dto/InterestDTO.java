package it.contrader.dto;

import java.util.List;

import it.contrader.model.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class InterestDTO {

	private Long id;

	private String interest;

	private List<Interestgroup> interestgroups;
	
	private List<Description> descriptions;
	
	private List<Library> libraries;
}
