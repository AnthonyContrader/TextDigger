package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.TagDTO;

import it.contrader.model.Tag;

@Component
public class TagConverter extends AbstractConverter<Tag, TagDTO> {

	@Override
	public Tag toEntity(TagDTO tagDTO) {
		Tag tag = null;
		if (tagDTO != null) {
			tag = new Tag(tagDTO.getId(), tagDTO.getTag());
		}
		return tag;
	}

	@Override
	public TagDTO toDTO(Tag tag) {
		TagDTO tagDTO = null;
		if (tag != null) {
			tagDTO = new TagDTO(tag.getId(), tag.getTag());

		}
		return tagDTO;
	}
}