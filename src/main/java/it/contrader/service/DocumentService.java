package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.DocumentConverter;
import it.contrader.dao.DocumentRepository;
import it.contrader.dto.DocumentDTO;
import it.contrader.model.Document;

@Service
public class DocumentService extends AbstractService<Document, DocumentDTO> {
	
	@Autowired
	DocumentConverter converter;
	
	@Autowired
	DocumentRepository repository;
	
	public DocumentDTO findByText(String text) {
		return converter.toDTO(repository.findByText(text));
	}

}
