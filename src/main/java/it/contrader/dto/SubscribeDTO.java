package it.contrader.dto;

import java.util.List;

import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscribeDTO {

	private Long idSubscribe;
	
	private String name;
	
	private List<User> users;
}


