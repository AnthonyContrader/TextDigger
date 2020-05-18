package it.contrader.model;

import java.sql.Blob;

public class Document {
	
	private int idDocument;
	
	private int userId;
	
	private Blob textBlob;
	
	public Document() {
		
	}
	
	public Document(int idDocument, int userId, Blob textBlob) {
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
		return "Document [idDocument=" + idDocument + ", userId=" + userId + ", textBlob=" + textBlob + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDocument;
		result = prime * result + ((textBlob == null) ? 0 : textBlob.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (idDocument != other.idDocument)
			return false;
		if (textBlob == null) {
			if (other.textBlob != null)
				return false;
		} else if (!textBlob.equals(other.textBlob))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	

}
