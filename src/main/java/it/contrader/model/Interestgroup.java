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
	
	@OneToMany(mappedBy = "interestgroup", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Subscribe> subscribes;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name ="interest_id", nullable = false)
	private Interest interest;

}
