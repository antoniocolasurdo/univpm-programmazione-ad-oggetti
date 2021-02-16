package it.univpm.progetto.data;

import java.util.Vector;

import it.univpm.progetto.model.Event;

public class EventsData {

	private static EventsData INSTANCE;

    /**
     * <p>
     * Lista degli eventi recuperati da Ticket Master
     * <p>
     */ 
    private Vector<Event> events;

	private EventsData() {
		events = new Vector<Event>();
	}
	
	public static EventsData getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new EventsData();
		}
		return INSTANCE;
	}
	
	public Vector<Event> getEvents() {
		return events;
	}
}