package it.univpm.progetto.model;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * Classe che definisce l'id e il nome
 */
public abstract class IdName {
	
	/**
	 * Definisce l'id
	 */
	private String id;
	/**
	 * Definisce il nome
	 */
	private String name;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}