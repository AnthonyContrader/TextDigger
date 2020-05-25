package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.TagDTO;
import it.contrader.model.Tag;

/**
 * 
 * @author Vittorio
 * 
 * Implementando questa l'interfaccia converter la classe TagConverter è OBBLIGATA ad implementarne i metodi
 *
 */
public class TagConverter  implements Converter<Tag, TagDTO> {
	
	/**
	 * Crea un oggetto di tipo TagDTO e lo riempie con i campi del parametro tag di tipo Tag.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public TagDTO toDTO(Tag tag) {
		TagDTO tagDTO = new TagDTO(tag.getId(), tag.getTagname(), tag.getPassword(), tag.getTagtype());
		return tagDTO;
	}

	/**
	 * Crea un oggetto di tipo Tag e lo riempie con i campi del parametro tag di tipo TagDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public Tag toEntity(TagDTO tagDTO) {
		Tag tag = new Tag(tagDTO.getId(), tagDTO.getTagname(), tagDTO.getPassword(), tagDTO.getTagtype());
		return tag;
	}
	
	/**
	 * Metodo per convertire le liste di Tag.
	 */
	@Override
	public List<TagDTO> toDTOList(List<Tag> tagList) {
		//Crea una lista vuota.
		List<TagDTO> tagDTOList = new ArrayList<TagDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Tag tag : tagList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			tagDTOList.add(toDTO(tag));
		}
		return tagDTOList;
	}

	
	
}
