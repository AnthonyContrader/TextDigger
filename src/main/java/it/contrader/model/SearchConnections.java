package it.contrader.model;

public class SearchConnections {
	
	private int idDocument;
	private int idTags;
	
	public SearchConnections() {
		
	}
	
	public SearchConnections(int idDocument, int idTags) {
		this.idDocument = idDocument;
		this.idTags = idTags;
	}

	public int getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(int idDocument) {
		this.idDocument = idDocument;
	}

	public int getIdTags() {
		return idTags;
	}

	public void setIdTags(int idTags) {
		this.idTags = idTags;
	}

	@Override
	public String toString() {
		return idDocument + "\t" + idTags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDocument;
		result = prime * result + idTags;
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
		SearchConnections other = (SearchConnections) obj;
		if (idDocument != other.idDocument)
			return false;
		if (idTags != other.idTags)
			return false;
		return true;
	}
	
	

}
