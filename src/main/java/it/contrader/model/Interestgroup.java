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
@Table(name = "interestgroups")
public class Interestgroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String interestgroup;
	
	@OneToMany
    private List<Subscribe> subscribes;
	
	@ManyToOne
	@JoinColumn(name = "id_interest")
	private Interest interest;

}
