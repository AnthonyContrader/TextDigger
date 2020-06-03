package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.DocumentDTO;
import it.contrader.model.Document;

@Component
public class DocumentConverter extends AbstractConverter<Document, DocumentDTO> {

	@Override
	public Document toEntity(DocumentDTO documentDto) {
		Document document = null;
		if(documentDto != null) {
			document = new Document(documentDto.getIdDocument(), documentDto.getText(), documentDto.getUsers());
		}
		return document;
	}

	@Override
	public DocumentDTO toDTO(Document document) {
		
		DocumentDTO documentDTO = null;
		if(document != null) {
			documentDTO = new DocumentDTO(document.getIdDocument(), document.getText(), document.getUsers());
		}
		return documentDTO;
		
	}

}
