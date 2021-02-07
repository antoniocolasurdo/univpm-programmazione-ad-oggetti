package it.univpm.progetto.model;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe</b> astratta che definisce l'id e il nome
 * <p>
 */
public abstract class IdName {
	
	
	private String id;

	private String name;

	/**
	 * <p>
	 * Ritorna l'id
	 * @return id
	 * <p>
	 */
	public String getId() {
		return id;
	}
	/**
	 * 
	 * @param id indica l'id
	 * 
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * <p>
	 * Ritorna il nome
	 * @return name
	 * <p>
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name indica il nome
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}

}