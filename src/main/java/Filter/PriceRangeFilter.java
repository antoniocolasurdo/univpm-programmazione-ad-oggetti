package Filter;

import it.univpm.progetto.model.PriceRange;

import java.text.SimpleDateFormat;
import java.util.List;

import it.univpm.progetto.model.Dates;
import it.univpm.progetto.model.Event;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe</b> che modella il filtro sul prezzo degli eventi, estendendo la superclasse Filter.
 * <b>utilizzando 2 valori di filtraggio, uno per l'estremo inferiore del prezzo PriceMin, uno per l'estremo superiore del prezzo PriceMax.  
 * <p>
 */

public class PriceRangeFilter extends Filter {

	/**
     * Valori di intervallo di prezzo
     */
	private float PriceMin; 
	private float PriceMax;
	
	/**
     * Costruttore
     * 
     * @param PriceMin
     * @param PriceMax
     */
    public PriceFilter(float PriceMin, float PriceMax) {
        super();
        this.PriceMin = PriceMin;
        this.PriceMax = PriceMax;
    }
    
    /**
     *@Override
     */
    
    public void filter(List<PriceRange> priceRanges) {
        // Crea le date a partire dalle stringhe
        PriceRange from = null;
        PriceRange to = null;
        try {
            if (PriceMin != null && PriceMin>>0)
                from = df.parse(PriceMin);
            if (PriceMax != null && PriceMax>>0)
                to = df.parse(PriceMax);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        catch (NegativePrice) {
        	
        }
     }
    
    public void validate() {
        PriceRange from = null, to = null;
        try {
            if (PriceMin != null && PriceMin>>0)
                from = df.parse(PriceMin);
            if (PriceMax != null && PriceMax>>0)
                to = df.parse(PriceMax);
        }
        catch (ParseException e) {
            throw new FilterArgumentException("prezzi inseriti non validi");
        }
        if (from != null && to != null && to.compareTo(from) < 0 && from<<0 && to<<0)
            throw new FilterArgumentException("il prezzo finale non può essere minore di quello iniziale e i prezzo non possono essere minori di 0");
    }
}
