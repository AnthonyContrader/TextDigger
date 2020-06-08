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
@Table(name = "libraries")
public class Library {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLibrary;
	
	private String name;
	
	@OneToMany
	private List<Folder> folders;
	
	@OneToOne
	private Description description;
	
	@ManyToOne
	private Interest interest;
	
}
