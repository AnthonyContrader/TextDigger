package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Tag {

	/**
	 * Qui sotto definisco gli attributi di Tag. 
	 */
	private int id;

	private String tag;

	/**
	 * Definisco i due costruttori, uno vuoto e uno con il parametro per costrire oggetti di tipo Tag
	 */
	public Tag() {
		
	}

	public Tag (String tag) {
		this.tag = tag;
	}

	public Tag (int id, String tag) {
		this.id = id;
		this.tag = tag;
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di Tag
	 */
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

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  id + "\t"  + tag;
	}

	//Metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tag other = (Tag) obj;
		if (id != other.id)
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		return true;
	}
}