package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.TagDTO;
import it.contrader.model.Tags;

public class TagConverter {
	
	public TagDTO toDTO(Tags tags) {
		
		TagDTO tagDTO = new TagDTO(tags.getIdTag(), tags.getTag());
		
		return tagDTO;
	}
	
	public Tags toEntity(TagDTO tagDTO) {
		
		Tags tags = new Tags(tagDTO.getIdTag(), tagDTO.getTag());
		return tags;
	}
	
	public List<TagDTO> toDTOList(List<Tags> listTags){
		
		List<TagDTO> tagDTOList = new ArrayList<TagDTO>(); 
		
		for(Tags tags : listTags) {
			tagDTOList.add(toDTO(tags));
		}
		return tagDTOList;
	}

}
