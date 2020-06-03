package it.contrader.dto;

import java.util.List;

import it.contrader.model.Document;
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
}
