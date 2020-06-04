package it.contrader.dto;

import java.util.List;

import it.contrader.model.Document;
import it.contrader.model.Interest;
import it.contrader.model.Subscribe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class InterestgroupDTO {

	private Long id;

	private String interestgroup;
	
	private List<Subscribe> subscribes;
	
	private Interest interest;

}
