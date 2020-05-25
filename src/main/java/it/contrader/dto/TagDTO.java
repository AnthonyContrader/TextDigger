package it.contrader.dto;

/**
 * 
 * @author Vittorio
 *
 *Il DTO ? simile al Model ma pu? contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "Tag".
 */
public class TagDTO {
	
	private int id;

	private String tag;
	
	
	public TagDTO() {
		
	}

	public TagDTO (String tag) {
		this.tag = tag;
	}

	public TagDTO (int id, String tag) {
		this.id = id;
		this.tag = tag;
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTag() {
		return tag;
	}

	@Override
	public String toString() {
		return  id + "\t"  + tag;
	}
}