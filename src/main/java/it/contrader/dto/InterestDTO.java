package it.contrader.dto;

import java.util.List;

import org.springframework.context.annotation.Description;

import it.contrader.model.Document;
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

	private List<Interestgroup> interestgroups;
	
	private List<Description> descriptions;
	
	private List<Library> libraries;
}
