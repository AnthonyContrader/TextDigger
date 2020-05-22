package it.contrader.model;


public class Document {
	
	private int idDocument;
	
	private User user;
	
	private String text;
	
	public Document() {
		
	}
	
	public Document(int idDocument, User user, String text) {
		this.idDocument = idDocument;
		this.user = user;
		this.text = text;
	}
	
	public Document( User user, String text) {
		this.user = user;
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

	public void setUserId(User user) {
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
		return "Document [idDocument=" + idDocument + ", userId=" + user + ", text=" + text + "]";
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
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (user != other.user)
			return false;
		return true;
	}
	
	

}
