package it.univpm.progetto.model;

import java.util.List;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * Classe che definisce i prodotti
 */
public class Product extends IdName {
	
	/**
	 * Definisce l'URL
	 */
	private String url;
	/**
	 * Definisce il tipo
	 */
	private String type;
	/**
	 * Definisce la lista di classificazioni
	 */
	private List<Classification> classifications;

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Classification> getClassifications() {
		return classifications;
	}
	public void setClassifications(List<Classification> classifications) {
		this.classifications = classifications;
	}
	
}