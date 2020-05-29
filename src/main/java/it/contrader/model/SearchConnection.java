package it.contrader.model;

public class SearchConnection {

	private int idDocument;
	
	private int idTag;
	
	public SearchConnection() {
		
	}
	 public SearchConnection(int idDocument, int idTag) {
		 
		 this.idDocument = idDocument;
		 this.idTag = idTag;
	 }
	 
	 public SearchConnection(int idDocument) {
		 this.idDocument = idDocument;
	 }
	 
	public int getIdDocument() {
		return idDocument;
	}
	public void setIdDocument(int idDocument) {
		this.idDocument = idDocument;
	}
	public int getIdTag() {
		return idTag;
	}
	public void setIdTag(int idTag) {
		this.idTag = idTag;
	}
	
	@Override
	public String toString() {
		return idDocument + "/t "+ idTag;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SearchConnection other = (SearchConnection) obj;
		if (idDocument != other.idDocument)
			return false;
		if (idTag != other.idTag)
			return false;
		return true;
	}
	
}
	
	
	
	 
	
	
	
	