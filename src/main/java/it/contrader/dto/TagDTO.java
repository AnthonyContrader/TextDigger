package it.contrader.dto;

import java.util.List;

import it.contrader.model.Description;
import it.contrader.model.SearchConnection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TagDTO {

	private Long id;

	private String tag;
	
	private Description description;
	
	private List<SearchConnection> searchconnections;

}
