package it.univpm.progetto.filter;

import java.util.Vector;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.univpm.progetto.model.Event;

public class FilterManager {

    private Vector<Filter> filtri;

    public FilterManager(@JsonProperty("segment") String segment, @JsonProperty("genre") String genre,
            @JsonProperty("state") String stateCode, @JsonProperty("priceMin") Float priceMin,
            @JsonProperty("priceMax") Float priceMax, @JsonProperty("startDate") String from,
            @JsonProperty("endDate") String to) {

        filtri = new Vector<Filter>();
        if (segment != null)
            filtri.add(new SegmentFilter(segment));
        if (genre != null)
            filtri.add(new GenreFilter(genre));
        if (stateCode != null)
            filtri.add(new StateFilter(stateCode));
        if (priceMin != null || priceMax != null)
            filtri.add(new PriceRangeFilter(priceMin, priceMax));
        if (from != null || to != null)
            filtri.add(new DateFilter(from, to));
    }

    public Vector<Filter> getFiltri() {
        return filtri;
    }

    public void filter(Vector<Event> eventi) {
        for (Filter filtro : filtri)
            filtro.filter(eventi);
    }

    public void validate() {
        for (Filter filtro : filtri)
            filtro.validate();
    }
}
