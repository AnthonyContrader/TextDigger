package it.contrader.dto;


import it.contrader.model.Description;
import it.contrader.model.Interest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryDTO {
	
	private Long id;
	
	private String name;

	
	private Description description;
	
	private Interest interest;

}
