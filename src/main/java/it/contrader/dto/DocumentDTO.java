package it.contrader.dto;

import java.sql.Blob;

public class DocumentDTO {
	
    private int idDocument;
	
	private int userId;
	
	private Blob textBlob;
	
	public DocumentDTO() {
		
	}
	
	public DocumentDTO(int idDocument, int userId, Blob textBlob) {
		
		this.idDocument = idDocument;
		this.userId = userId;
		this.textBlob = textBlob;
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

	public Blob getTextBlob() {
		return textBlob;
	}

	public void setTextBlob(Blob textBlob) {
		this.textBlob = textBlob;
	}

	@Override
	public String toString() {
		return "DocumentDTO [idDocument=" + idDocument + ", userId=" + userId + ", textBlob=" + textBlob + "]";
	}
	
	

}
