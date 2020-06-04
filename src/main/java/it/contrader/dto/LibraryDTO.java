package it.contrader.dto;

import java.util.List;

import it.contrader.model.Description;
import it.contrader.model.Folder;
import it.contrader.model.Interest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryDTO {
	
	private Long idLibrary;
	
	private String name;
	
	private List<Folder> folders;
	
	private Description description;
	
	private Interest interest;

}
