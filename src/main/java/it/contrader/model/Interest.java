package it.contrader.model;

import javax.persistence.*;

import org.springframework.context.annotation.Description;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

	@OneToMany(mappedBy = "interest", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Interestgroup> interestgroup;
	
	@OneToMany(mappedBy = "interest", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Description> descriptions;
	
	@OneToMany(mappedBy = "interest", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Library> libraries;
}
