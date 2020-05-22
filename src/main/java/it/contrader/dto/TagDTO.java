package it.contrader.dto;

public class TagDTO {
	
	private int idTag;
	
	private String tag;
	
	public TagDTO() {
		
	}

	public TagDTO(String tag) {
		
		this.tag = tag;
	}
	
	public TagDTO(int idTag, String tag) {
		this.idTag = idTag;
		this.tag = tag;
	}

	public int getIdTag() {
		return idTag;
	}

	public void setIdTag(int idTag) {
		this.idTag = idTag;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return idTag + "\t" + tag;
	}
	
	
}