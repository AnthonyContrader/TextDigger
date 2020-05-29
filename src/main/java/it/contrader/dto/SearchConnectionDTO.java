package it.contrader.dto;

public class SearchConnectionDTO {

	private int idDocument;
	
	private int idTag;
	
	public SearchConnectionDTO() {
		
	}
	
	public SearchConnectionDTO(int idDocument, int idTag) {
		
		this.idDocument = idDocument;
		this.idTag = idTag;
	}
	
	public SearchConnectionDTO(int idDocument) {
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
		return idDocument + "/t" + idTag;
	}
	
}
