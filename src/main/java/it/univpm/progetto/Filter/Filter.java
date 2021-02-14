package it.univpm.progetto.Filter;

import java.util.Vector;
import it.univpm.progetto.model.Event;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 *         <p>
 *         <b>Classe Astratta</b> dei filtri implementati
 *         <p>
 */

public abstract class Filter {
    /**
     * Filtra le misure in ingresso
     * 
     * @param misure
     */
    public abstract void filter(Vector<Event> eventi);

    /**
     * Verifica che i parametri passati in ingresso al filtro siano validi o meno
     */
    public abstract void validate();
}
