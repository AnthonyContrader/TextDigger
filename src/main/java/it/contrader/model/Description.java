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
@Table(name ="descriptions")
public class Description {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDescription;
	
	@Column(name ="description")
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="id_folder")
	private Folder folder;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="id_library")
	private Library library;
	
	@OneToOne(mappedBy = "description", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Document document;
	
	@OneToMany(mappedBy = "description", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Tag> tags;
	
	@ManyToOne
	@JoinColumn(name ="id_interest")
	private Interest interest;
	
	

}
