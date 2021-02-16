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

public class FilterManager {

    private Vector<Filter> filtri;

    public FilterManager(@JsonProperty("segment") String segment, @JsonProperty("genre") String genre,
            @JsonProperty("state") String stateCode, @JsonProperty("priceMin") Float priceMin,
            @JsonProperty("priceMax") Float priceMax, @JsonProperty("startDate") String from,
            @JsonProperty("endDate") String to) {

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

    public Vector<Filter> getFiltri() {
        return filtri;
    }

    @SuppressWarnings("unchecked")
	public Vector<Event> filter(Vector<Event> eventi) {
    	Vector<Event> filteredEvents = (Vector<Event>) eventi.clone();
    	
        for (Filter filtro : filtri) {
            filtro.filter(filteredEvents);
        }
        
        return filteredEvents;
    }

    public void validate() throws WrongFormatDateException, WrongEndDateException, WrongStartDateException, WrongGenreException, WrongSegmentException, WrongStateException, WrongNegativePriceMinException, WrongPriceMaxException {
        for (Filter filtro : filtri) {
            filtro.validate();
        }
    }
}