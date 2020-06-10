package it.contrader.model;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name ="interest")
public class Interest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String interest;

	@OneToMany (mappedBy = "interest")
    private List<Interestgroup> interestGroup;
	
	@OneToMany (mappedBy = "interest")
    private List<Description> descriptions;
	
	@OneToMany (mappedBy = "interest")
    private List<Library> libraries;
}
