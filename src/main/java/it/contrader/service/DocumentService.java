package it.contrader.service;

import java.util.List;

import it.contrader.converter.DocumentConverter;
import it.contrader.dao.DocumentDAO;
import it.contrader.dto.DocumentDTO;

public class DocumentService {
	
	private DocumentDAO documentDAO;
	private DocumentConverter documentConverter;
	
	public DocumentService() {
		this.documentDAO = new DocumentDAO();
		this.documentConverter = new DocumentConverter();
	}
	
	public List<DocumentDTO> getAll(){
		return documentConverter.toDTOList(documentDAO.getAll());
	}
	
	public DocumentDTO read(int id) {
		return documentConverter.toDTO(documentDAO.readDocumentById(id));	
	}
	
	public boolean insert(DocumentDTO documentDTO) {
		return documentDAO.insertDoc(documentConverter.toEntity(documentDTO));
	}
	
	public boolean update(DocumentDTO documentDTO) {
		return documentDAO.updateDocument(documentConverter.toEntity(documentDTO));
	}
	
	public boolean delete(int id) {
		return documentDAO.deleteDocument(id);
	}

}
