package it.univpm.progetto.filter;

import java.util.Vector;
import it.univpm.progetto.model.Event;
import it.univpm.progetto.exception.*;

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
     * @throws WrongGenreException 
     * @throws WrongFormatDateException
     * @throws WrongEndDateException
     * @throws WrongStartDateException
     * @throws WrongSegmentException
     * @throws WrongStateException
     * @throws WrongNegativePriceMinException
     * @throws WrongPriceMaxException
     */
    public abstract void validate() throws WrongFormatDateException, WrongEndDateException, WrongStartDateException, WrongGenreException, WrongSegmentException, WrongStateException, WrongNegativePriceMinException, WrongPriceMaxException;
}
