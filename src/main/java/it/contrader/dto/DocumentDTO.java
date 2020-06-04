package it.contrader.dto;

import it.contrader.model.Description;
import it.contrader.model.Folder;
import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDTO {
	
	private Long idDocument;
	
	private String text;
	
	private User user;
	
	private Folder folder;
	
	private Description description;

}
