package it.univpm.progetto.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketMasterRoot {

	@JsonProperty("_embedded")
	private TicketMasterEmbedded embedded;

	public TicketMasterEmbedded getEmbedded() {
		return embedded;
	}

	public void setEmbedded(TicketMasterEmbedded embedded) {
		this.embedded = embedded;
	}

}