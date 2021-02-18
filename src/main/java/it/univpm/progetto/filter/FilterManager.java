package it.univpm.progetto.filter;

import java.util.Vector;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.univpm.progetto.exception.WrongEndDateException;
import it.univpm.progetto.exception.WrongFormatDateException;
import it.univpm.progetto.exception.WrongGenreException;
import it.univpm.progetto.exception.WrongNegativePriceMinException;
import it.univpm.progetto.exception.WrongPriceMaxException;
import it.univpm.progetto.exception.WrongSegmentException;
import it.univpm.progetto.exception.WrongStartDateException;
import it.univpm.progetto.exception.WrongStateException;
import it.univpm.progetto.model.Event;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe</b> che gestisce i filtri sugli eventi utilizzati per le varie tipologie di statistiche
 * </p>
 */
public class FilterManager {

    private Vector<Filter> filtri;

    /**
     * <p>Costruttore</p>
     * 
     * @param segment indica la classificazione
     * @param genre indica il genere
     * @param stateCode indica lo stato
     * @param priceMin indica il prezzo minimo
     * @param priceMax indica il prezzo massimo
     * @param from indica la data iniziale nel formato gg/mm/aaaa
     * @param to indica la data finale nel formato gg/mm/aaaa
     * 
     */
    public FilterManager(@JsonProperty("segment") String segment, @JsonProperty("genre") String genre,
            @JsonProperty("state") String stateCode, @JsonProperty("priceMin") Float priceMin,
            @JsonProperty("priceMax") Float priceMax, @JsonProperty("startDate") String from,
            @JsonProperty("endDate") String to) {

    	// Crea un nuovo vettore filtri che conterrà l'elenco dei filtri da applicare
        filtri = new Vector<Filter>();
        if (segment != null) {
            filtri.add(new SegmentFilter(segment));
        }
        if (genre != null) {
            filtri.add(new GenreFilter(genre));
        }
        if (stateCode != null) {
            filtri.add(new StateFilter(stateCode));
        }
        if (priceMin != null || priceMax != null) {
            filtri.add(new PriceRangeFilter(priceMin, priceMax));
        }
        if (from != null || to != null) {
            filtri.add(new DateFilter(from, to));
        }
    }

    /**
     * <p>Metodo di recupero dei filtri da applicare</p>
     * 
     * @return filtri
     * 
     */
    public Vector<Filter> getFiltri() {
        return filtri;
    }

    /**
     * <p>Metodo di esecuzione dei filtri su una copia degli eventi</p>
     * 
     * @param eventi lista degli eventi da filtrare
     * 
     * @return filtri
     *
     */
    @SuppressWarnings("unchecked")
	public Vector<Event> filter(Vector<Event> eventi) {
    	Vector<Event> filteredEvents = (Vector<Event>) eventi.clone();
    	
        for (Filter filtro : filtri) {
            filtro.filter(filteredEvents);
        }
        
        return filteredEvents;
    }

    /**
     * <p>Metodo di validazione dei filtri con eventuale gestione delle varie eccezioni</p>
     * 
     * @throws WrongGenreException genere errato
     * @throws WrongFormatDateException formato data errato
     * @throws WrongEndDateException data finale minore della data iniziale
     * @throws WrongStartDateException data iniziale minore della data corrente
     * @throws WrongSegmentException classificazione errata
     * @throws WrongStateException stato errato
     * @throws WrongNegativePriceMinException prezzo minimo negativo
     * @throws WrongPriceMaxException prezzo massimo minore del prezzo minimo
     * 
     */
    public void validate() throws WrongFormatDateException, WrongEndDateException, WrongStartDateException, WrongGenreException, WrongSegmentException, WrongStateException, WrongNegativePriceMinException, WrongPriceMaxException {
        for (Filter filtro : filtri) {
            filtro.validate();
        }
    }
}