package it.contrader.dto;

import java.util.List;

import it.contrader.model.Description;
import it.contrader.model.Document;
import it.contrader.model.Library;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FolderDTO {

	private Long idFolder;
	
	private String name;
	
	private List<Document> documents;
	
	private Library library;
	
	private Description description;
}
