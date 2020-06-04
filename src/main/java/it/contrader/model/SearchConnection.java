package it.contrader.model;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "searchconnections")
public class SearchConnection {

	
	@Column (name = "idTag")
	private int idDocument;
	private int idTag;
	
	
	@ManyToOne
	@JoinColumn(name = "Tag_Id")
	private Tag tag;
	
	@ManyToOne
	@JoinColumn(name = "Document_Id")
	private Document document;
	
}
