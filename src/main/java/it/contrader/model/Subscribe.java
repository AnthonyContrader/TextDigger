package it.contrader.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subscribe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSubscribe;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne 
	@JoinColumn(name = "id_user")
	private User user;
	
	
	@ManyToOne 
	@JoinColumn (name = "interestgroup")
	private Interestgroup interestgroup;
}
