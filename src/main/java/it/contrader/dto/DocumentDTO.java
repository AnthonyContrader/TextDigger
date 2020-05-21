package it.contrader.dto;

import it.contrader.model.User;

public class DocumentDTO {
	
    private int idDocument;
	
	private User user;
	
	private String text;
	
	public DocumentDTO() {
		
	}
	
	public DocumentDTO(int idDocument, User user, String text) {
		
		this.idDocument = idDocument;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setTextBlob(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "DocumentDTO [idDocument=" + idDocument + ", user=" + user + ", text=" + text + "]";
	}
	
	

}
