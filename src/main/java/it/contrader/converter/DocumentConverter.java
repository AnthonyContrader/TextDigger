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
			document = new Document(documentDto.getId(), documentDto.getText(), documentDto.getUser(), documentDto.getFolder(), documentDto.getDescription());
		}
		return document;
	}

	@Override
	public DocumentDTO toDTO(Document document) {
		
		DocumentDTO documentDTO = null;
		if(document != null) {
			documentDTO = new DocumentDTO(document.getId(), document.getText(), document.getUser(), document.getFolder(),document.getDescription());
		}
		return documentDTO;
		
	}

}
