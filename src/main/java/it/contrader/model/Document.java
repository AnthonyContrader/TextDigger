package it.contrader.model;

import java.sql.Blob;

public class Document {
	
	private int idDocument;
	
	private User user;
	
	private String textBlob;
	
	public Document() {
		
	}
	
	public Document( User user, String textBlob) {
		this.user = user;
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

	public void setUserId(User user) {
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
		return "Document [idDocument=" + idDocument + ", userId=" + user + ", textBlob=" + textBlob + "]";
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
		if (user != other.user)
			return false;
		return true;
	}
	
	

}
