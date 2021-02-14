package it.univpm.progetto.Filter;

import java.util.Iterator;
import java.util.Vector;
import it.univpm.progetto.exception.FilterException;
import it.univpm.progetto.model.Event;

 /**
  * @author Antonio Colasurdo e Daniele Sergiacomi
  * 
  * <p>
  * <b>Classe</b> che modella il filtro sul prezzo degli eventi, estendendo la superclasse Filter.
  * <b>Utilizzando 2 valori di filtraggio, uno per l'estremo inferiore del prezzo PriceMin,
  * <b>uno per l'estremo superiore del prezzo PriceMax.  
  * <p>
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
     * @param PriceMin
     * @param PriceMax
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

    public void validate() {
        if (priceMin != null && priceMin < 0)
            throw new FilterException("Il prezzo minimo non può essere negativo");
        if (priceMin != null && priceMax != null && priceMax < priceMin)
            throw new FilterException("Il prezzo massimo non può essere minore di quello minimo");
    }

}