package it.contrader.dto;

public class SearchConnectionsDTO {
	
	private int idDocument;
	
	private int idTags;
	
	public SearchConnectionsDTO() {
		
	}

	public SearchConnectionsDTO(int idDocument, int idTags) {
		
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
		return idDocument + "\t\t" + idTags;
	}
	
}
