package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import it.contrader.model.Document;
import it.contrader.model.Folder;
import it.contrader.model.Interest;
import it.contrader.model.Library;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class DescriptionDTO {
	
	private Long id;
	
	private String description;
	
	private Folder folder;
	
	private Library library;
	
	private Document document;
	
	private Interest interest;

}
