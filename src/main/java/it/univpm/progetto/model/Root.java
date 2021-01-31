package it.univpm.progetto.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * Classe che definisce l'elemento radice degli eventi
 */
public class Root {
	
	@JsonProperty("_embedded")
	private Embedded embedded;

	public Embedded getEmbedded() {
		return embedded;
	}

	public void setEmbedded(Embedded embedded) {
		this.embedded = embedded;
	}

}