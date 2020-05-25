package it.contrader.service;

import it.contrader.converter.TagConverter;
import it.contrader.dao.TagDAO;
import it.contrader.dto.TagDTO;
import it.contrader.model.Tag;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class TagService extends AbstractService<Tag, TagDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public TagService(){
		this.dao = new TagDAO();
		this.converter = new TagConverter();
	}
	

}
