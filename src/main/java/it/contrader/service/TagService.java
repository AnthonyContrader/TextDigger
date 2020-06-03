package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.TagConverter;
import it.contrader.dao.TagRepository;
import it.contrader.dto.TagDTO;
import it.contrader.model.Tag;

@Service
public class TagService extends AbstractService<Tag, TagDTO> {

	@Autowired
	private TagConverter converter;
	@Autowired
	private TagRepository repository;

	public TagDTO findByTag(String tag) {
		return converter.toDTO(repository.findByTag(tag));
	}

}
