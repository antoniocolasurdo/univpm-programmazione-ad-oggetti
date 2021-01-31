package it.univpm.progetto.model;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * Classe che definisce lo sponsor
 */
public class Promoter extends IdName{
	
	/**
	 * Definisce la descrizione
	 */
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}