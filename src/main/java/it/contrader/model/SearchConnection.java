package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class SearchConnection {

	@Column (name = "idTag")
	private int idDocument;
	private int idTag;
	
	/*
	@OneToMany(mappedBy = "IdTag")
	@JoinColumn(name = "Tag_Id")
	private List<Document> documents;
	*/
}
