package it.contrader.service;

import it.contrader.converter.DocumentConverter;
import it.contrader.dao.DocumentDAO;
import it.contrader.dto.DocumentDTO;
import it.contrader.model.Document;

public class DocumentService extends AbstractService<Document, DocumentDTO> {
	
	public DocumentService() {
		this.dao = new DocumentDAO();
		this.converter = new DocumentConverter();
	}

}
