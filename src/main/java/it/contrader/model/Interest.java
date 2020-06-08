package it.contrader.model;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "interests")
public class Interest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String interest;

	@OneToMany
    private List<Interestgroup> interestGroup;
	
	@OneToMany
    private List<Description> descriptions;
	
	@OneToMany
    private List<Library> libraries;
}
