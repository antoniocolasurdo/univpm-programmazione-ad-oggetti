package it.univpm.progetto.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketMasterEmbedded {

	@JsonProperty("events")
	private List<TicketMasterEvent> events;

	public List<TicketMasterEvent> getEvents() {
		return events;
	}

	public void setEvents(List<TicketMasterEvent> events) {
		this.events = events;
	}

}