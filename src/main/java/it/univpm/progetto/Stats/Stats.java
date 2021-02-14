package it.univpm.progetto.stats;

import java.util.Vector;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.univpm.progetto.model.Event;

public interface Stats {
	
    /**
     * Restituisce il numero di eventi presenti
     * 
     * @return
     */
    public int getNumEvents(Vector<Event> eventi);

    /**
     * Restituisce il numero di eventi presenti raggruppati per segmento e genere
     * 
     * @param eventi
     * @return
     */
    public ObjectNode getNumEventsGenre(Vector<Event> eventi);

}
