package it.contrader.model;

public class Document {
	
	private int idDocument;
	
	private int userId;
	
	private String text;

	public Document(int idDocument, int userId, String text) {
		this.idDocument = idDocument;
		this.userId = userId;
		this.text = text;
	}

	public Document(int userId, String text) {
		this.userId = userId;
		this.text = text;
	}
	

	public Document(String text) {
		super();
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
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Document [idDocument=" + idDocument + ", user=" + userId + ", text=" + text + "]";
	}
	
	

}
