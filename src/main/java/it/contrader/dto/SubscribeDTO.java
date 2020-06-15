package it.contrader.dto;


import it.contrader.model.Interestgroup;
import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscribeDTO {

	private Long id;
	
	private User user;
	
	private Interestgroup interestgroup;
}


