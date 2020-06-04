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
	
	@Column(name = "name")
	private String name;
	

	@OneToMany(mappedBy = "folder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Document> documents;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name ="id_library",  nullable = false)
	private Library library;
	
	@OneToOne(mappedBy = "folder")
	private Description description;

}
