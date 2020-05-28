package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.DocumentDTO;
import it.contrader.model.Document;

public class DocumentConverter implements Converter<Document, DocumentDTO> {

	@Override
	public DocumentDTO toDTO(Document document) {
		DocumentDTO documentDTO = new DocumentDTO(document.getIdDocument(), document.getUserId(), document.getText());
		return documentDTO;
	}

	@Override
	public Document toEntity(DocumentDTO documentDto) {
		Document document = new Document(documentDto.getIdDocument(), documentDto.getUserId(), documentDto.getText());
		return document;
	}

	@Override
	public List<DocumentDTO> toDTOList(List<Document> documentList) {
		List<DocumentDTO> documentDTOList = new ArrayList<DocumentDTO>();
		
		for(Document document : documentList) {
			documentDTOList.add(toDTO(document));
		}
		
		return documentDTOList;
	}

}
