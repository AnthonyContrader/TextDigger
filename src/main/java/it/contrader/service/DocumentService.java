package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.DocumentRepository;
import it.contrader.dto.DocumentDTO;
import it.contrader.model.Document;

@Service
public class DocumentService extends AbstractService<Document, DocumentDTO> {
	
	public DocumentDTO findByText(String text) {
		return converter.toDTO(((DocumentRepository)repository).findByText(text));
	}

}
