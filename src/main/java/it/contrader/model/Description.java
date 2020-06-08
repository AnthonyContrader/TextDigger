package it.contrader.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="descriptions")
public class Description {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDescription;
	
	private String description;
	
	@OneToOne
	private Folder folder;
	
	@OneToOne
	private Library library;
	
	@OneToOne
	private Document document;
	
	@OneToMany
	private List<Tag> tags;
	
	@ManyToOne
	@JoinColumn(name ="id_interest")
	private Interest interest;
	
	

}
