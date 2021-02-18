package it.univpm.progetto.filter;

import java.util.Vector;
import it.univpm.progetto.model.Event;
import it.univpm.progetto.exception.*;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 *         <p>
 *         <b>Classe Astratta</b> dei filtri implementati
 *         </p>
 */

public abstract class Filter {
    /**
     * Filtra le misure in ingresso
     * 
     * @param eventi indica il vettore degli eventi da filtrare
     */
    public abstract void filter(Vector<Event> eventi);

    /**
     * Verifica che i parametri passati in ingresso al filtro siano validi o meno
     * @throws WrongGenreException genere errato
     * @throws WrongFormatDateException formato data errato
     * @throws WrongEndDateException data finale minore della data iniziale
     * @throws WrongStartDateException data iniziale minore della data corrente
     * @throws WrongSegmentException classificazione errata
     * @throws WrongStateException stato errato
     * @throws WrongNegativePriceMinException prezzo minimo negativo
     * @throws WrongPriceMaxException prezzo massimo minore del prezzo minimo
     */
    public abstract void validate() throws WrongFormatDateException, WrongEndDateException, WrongStartDateException, WrongGenreException, WrongSegmentException, WrongStateException, WrongNegativePriceMinException, WrongPriceMaxException;
}
