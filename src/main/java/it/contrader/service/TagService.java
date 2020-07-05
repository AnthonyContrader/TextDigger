package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.TagRepository;
import it.contrader.dto.TagDTO;
import it.contrader.model.Tag;

@Service
public class TagService extends AbstractService<Tag, TagDTO> {

	public TagDTO findByTag(String tag) {
		return converter.toDTO(((TagRepository)repository).findByTag(tag));
	}

}
