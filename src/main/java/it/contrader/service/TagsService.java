package it.contrader.service;

import java.util.List;

import it.contrader.converter.TagConverter;
import it.contrader.dao.TagDAO;
import it.contrader.dto.TagDTO;

public class TagsService {
	
	private TagDAO tagDAO;
	private TagConverter tagConverter;
	
	public TagsService () {
		this.tagDAO = new TagDAO();
		this.tagConverter = new TagConverter();
	}
	
	public List<TagDTO> getAll(){
		return tagConverter.toDTOList(tagDAO.getAll());
	}
	
	public TagDTO read(int id) {
		return tagConverter.toDTO(tagDAO.read(id));
	}
	
	public boolean insert(TagDTO tagDTO) {
		return tagDAO.insertTag(tagConverter.toEntity(tagDTO));
	}
	
	public boolean update(TagDTO tagDTO) {
		return tagDAO.update(tagConverter.toEntity(tagDTO));
	}
	
	public boolean delete(int id) {
		return tagDAO.delete(id);
	}

}
