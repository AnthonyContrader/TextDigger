package it.contrader.dto;

import it.contrader.model.Document;
import it.contrader.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchConnectionDTO {
	
	private Long id;
	
	private String text;
	
	private Tag tag;
	
	private Document document;

}
