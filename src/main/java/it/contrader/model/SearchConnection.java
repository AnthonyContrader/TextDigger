package it.contrader.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

	@Id
	private Long idTag;
	private Long idDocument;
	
	@ManyToOne
	private Tag tag;
	
	@ManyToOne
	private Document document;
	
}
