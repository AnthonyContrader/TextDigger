package it.contrader.dto;

import it.contrader.model.User;

public class DocumentDTO {
	
	private int idDocument;
	
	private int userId;
	
	private String text;

	public DocumentDTO(int idDocument, int userId, String text) {
		this.idDocument = idDocument;
		this.userId = userId;
		this.text = text;
	}
	
	public DocumentDTO(int userId, String text) {
		this.userId = userId;
		this.text = text;
	}
	
	public DocumentDTO(String text) {
		this.text = text;
	}

	public int getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(int idDocument) {
		this.idDocument = idDocument;
	}

	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "DocumentDTO [idDocument=" + idDocument + ", user=" + userId + ", text=" + text + "]";
	}
	

}
