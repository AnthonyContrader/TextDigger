package it.contrader.dto;

import java.util.List;

import it.contrader.model.Document;
import it.contrader.model.Folder;
import it.contrader.model.Interest;
import it.contrader.model.Library;
import it.contrader.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DescriptionDTO {
	
	private Long idDescription;
	
	private String description;
	
	private Folder folder;
	
	private Library library;
	
	private Document document;
	
	private List<Tag> tags;
	
	private Interest interest;

}
