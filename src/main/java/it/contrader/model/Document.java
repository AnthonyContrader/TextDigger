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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "documents")
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String text;
	
	@OneToMany
	private List<SearchConnection> searchconnections;
	
	
	@ManyToOne
	@JoinColumn(name ="id_user")
	private User user;
	
	
	@ManyToOne
	@JoinColumn(name ="id_folder")
	private Folder folder;
	
	@OneToOne
	private Description description;

}
