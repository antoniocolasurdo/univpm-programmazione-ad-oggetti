package it.univpm.progetto.data;

import java.util.Vector;

import it.univpm.progetto.model.Event;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p><b>Classe</b> che centralizza gli eventi disponibili recuperati da TicketMaster</p>
 * <p>Viene utilizzato il pattern <b>singleton</b> in quanto gli eventi recuperati devono essere disponibili sia per la classe di servizio che per la classe di elaborazione delle statistiche</p>
 */
public class EventsData {

	private static EventsData INSTANCE;

    /**
     * <p>Lista degli eventi recuperati da Ticket Master</p>
     */ 
    private Vector<Event> events;

    /**
     * <p>Costruttore della classe, inizializza il vettore contenente gli eventi</p>
     * 
     */
	private EventsData() {
		events = new Vector<Event>();
	}
	
	/**
	 * <p>Restituisce l'istanza della classe singleton</p>
	 * 
	 * @return EventsData
	 * 
	 */
	public static EventsData getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new EventsData();
		}
		return INSTANCE;
	}
	
	/**
	 * <p>Metodo di recupero degli eventi</p>
	 * 
	 * @return events
	 * 
	 */
	public Vector<Event> getEvents() {
		return events;
	}
}