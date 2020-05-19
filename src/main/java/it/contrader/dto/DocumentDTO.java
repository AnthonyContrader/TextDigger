package it.contrader.dto;

import java.sql.Blob;

import it.contrader.model.User;

public class DocumentDTO {
	
    private int idDocument;
	
	private User user;
	
	private String textBlob;
	
	public DocumentDTO() {
		
	}
	
	public DocumentDTO(int idDocument, User user, String textBlob) {
		
		this.idDocument = idDocument;
		this.user = user;
		this.textBlob = textBlob;
	}
	
	public DocumentDTO(String textBlob) {
		this.textBlob = textBlob;
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

	public String getTextBlob() {
		return textBlob;
	}

	public void setTextBlob(String textBlob) {
		this.textBlob = textBlob;
	}

	@Override
	public String toString() {
		return "DocumentDTO [idDocument=" + idDocument + ", user=" + user + ", textBlob=" + textBlob + "]";
	}
	
	

}
