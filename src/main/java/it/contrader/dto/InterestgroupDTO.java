package it.contrader.dto;

import it.contrader.model.Interest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class InterestgroupDTO {

	private Long id;

	private String interestgroup;
	
	private Interest interest;

}
