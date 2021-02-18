package it.univpm.progetto.stats;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

import it.univpm.progetto.model.Event;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Interfaccia</b> delle funzioni relative alle statistiche
 * </p>
 */
public interface Stats {

    /**
     * <p>Restituisce il numero di eventi presenti in ogni stato</p>
     * 
     * @param eventi lista degli eventi da elaborare
     * 
     * @return numEvents
     */
    public HashMap<String, Integer> getNumEvents(Vector<Event> eventi);

    /**
     * <p>Restituisce il numero di eventi presenti raggruppati per segmento e genere</p>
     * 
     * @param eventi lista degli eventi da elaborare
     *  
     * @return numEventsGen
     */
    public HashMap<String, HashMap<String, Integer>> getNumEventsGenre(Vector<Event> eventi);

    /**
     * <p>Restituisce l'insieme degli statescodes in cui si terranno gli eventi</p>
     * 
     * @param eventi lista degli eventi da elaborare 
     * 
     * @return statesCodes
     */
    public HashSet<String> getStates(Vector<Event> eventi);

    /**
     * <p>Restituisce l'insieme dei valori minimo, massimo e medio degli eventi mensilmente e con date personalizzate</p>
     * 
     * @param eventi lista degli eventi da elaborare
     * @param weekNum numero di settimane prese
     * 
     * @return numEvents
     */
    public HashMap<String, ValoriMinimoMassimoMedio> numEventsInterval(Vector<Event> eventi, int weekNum);

}