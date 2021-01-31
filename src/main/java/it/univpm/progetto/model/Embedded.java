package it.univpm.progetto.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * Classe che definisce il corpo degli eventi
 */
public class Embedded {
	/**
	 * Definisce la lista di tutti gli eventi
	 */
	@JsonProperty("events")
	private List<Event> events;
	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}