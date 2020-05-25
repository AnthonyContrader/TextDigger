package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.DocumentDTO;
import it.contrader.model.Document;

public class DocumentConverter {
	
	public DocumentDTO toDTO(Document document) {
		
		DocumentDTO documentDTO = new DocumentDTO(document.getIdDocument(), document.getUser(), document.getText());
		
		return documentDTO;
	}
	
	public Document toEntity(DocumentDTO documentDTO) {
		Document document = new Document(documentDTO.getIdDocument() ,documentDTO.getUser(), documentDTO.getText());
		
		return document;
	}
	
	public List<DocumentDTO> toDTOList(List<Document> documentList){
		List<DocumentDTO> documentDtoList = new ArrayList<DocumentDTO>();
		
		for(Document document : documentList) {
			documentDtoList.add(toDTO(document));
		}
		return documentDtoList;
	}

}
