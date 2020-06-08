package it.contrader.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "folders")
public class Folder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFolder;
	
	private String name;

	@OneToMany
	private List<Document> documents;
	
	@ManyToOne
	private Library library;
	
	@OneToOne
	private Description description;

}
