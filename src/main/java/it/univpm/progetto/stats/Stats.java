package it.univpm.progetto.stats;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

import it.univpm.progetto.model.Event;

public interface Stats {

    /**
     * Restituisce il numero di eventi presenti in ogni stato
     * 
     * @return
     */
    public HashMap<String, Integer> getNumEvents(Vector<Event> list);

    /**
     * Restituisce il numero di eventi presenti raggruppati per segmento e genere
     * 
     * @param eventi
     * @return
     */
    public HashMap<String, int[]> getNumEventsGenre(Vector<Event> eventi);

    /**
     * Restituisce l'insieme degli statescodes in cui si terranno gli eventi
     * 
     * @param eventi
     * @return
     */
    public HashSet<String> getStates(Vector<Event> eventi);

}