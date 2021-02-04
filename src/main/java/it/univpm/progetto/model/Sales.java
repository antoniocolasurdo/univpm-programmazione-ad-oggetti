package it.univpm.progetto.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * Classe che definisce le vendite
 */
public class Sales {
	
	/**
	 * Definisce la vendita pubblica
	 */
	@JsonProperty("public")
	private PublicSale publicSale;
	
	/**
	 * Definisce la prevendita
	 */
	@JsonProperty("presales")
	private List<PreSale> preSales;
	
}