package it.contrader.dto;


import it.contrader.model.Description;
import it.contrader.model.Library;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FolderDTO {

	private Long id;
	
	private String name;
	
	private Library library;
	
	private Description description;
}
