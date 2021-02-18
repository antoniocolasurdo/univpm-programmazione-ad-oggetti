package it.univpm.progetto.filter;

import java.util.Iterator;
import java.util.Vector;
import it.univpm.progetto.exception.WrongNegativePriceMinException;
import it.univpm.progetto.exception.WrongPriceMaxException;
import it.univpm.progetto.model.Event;

 /**
  * @author Antonio Colasurdo e Daniele Sergiacomi
  * 
  * <p>
  * <b>Classe</b> che modella il filtro sul prezzo degli eventi, estendendo la superclasse Filter.
  *    Utilizzando 2 valori di filtraggio, uno per l'estremo inferiore del prezzo PriceMin,
  *    uno per l'estremo superiore del prezzo PriceMax.  
  * </p>
  */

public class PriceRangeFilter extends Filter {

    /**
     * Valori di intervallo di prezzo
     */
    private Float priceMin;
    private Float priceMax;

    /**
     * Costruttore
     * 
     * @param PriceMin prezzo minimo
     * @param PriceMax prezzo massimo
     */
    public PriceRangeFilter(float PriceMin, float PriceMax) {
        super();
        this.priceMin = PriceMin;
        this.priceMax = PriceMax;
    }

    @Override
    public void filter(Vector<Event> eventi) {
        if (priceMin != null) {
            Iterator<Event> iter = eventi.iterator();
            while (iter.hasNext()) {
                Event evento = iter.next(); // Prossimo evento
                if (evento.getPriceRange().getMin() < priceMin)
                    iter.remove();
            }
        }
        if (priceMax != null) {
            Iterator<Event> iter = eventi.iterator();
            while (iter.hasNext()) {
                Event evento = iter.next(); // Prossimo evento
                if (evento.getPriceRange().getMax() > priceMax)
                    iter.remove();
            }
        }
    }

    // Recupera le eccezioni di prezzo minimo e massimo filtrati errati
    public void validate() throws WrongNegativePriceMinException, WrongPriceMaxException {
        if (priceMin != null && priceMin < 0)
            throw new WrongNegativePriceMinException("Il prezzo minimo non può essere negativo");
        if (priceMin != null && priceMax != null && priceMax < priceMin)
            throw new WrongPriceMaxException("Il prezzo massimo non può essere minore di quello minimo");
    }

}