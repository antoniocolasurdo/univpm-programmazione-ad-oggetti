package it.univpm.progetto.filter;

import java.util.Iterator;
import java.util.Vector;
import it.univpm.progetto.exception.FilterException;
import it.univpm.progetto.model.Event;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe</b> che modella il filtro sui generi degli eventi, estendendo la superclasse Filter.
 * <p>
 */

public class GenreFilter extends Filter {
    private String genre;

    public GenreFilter(String genre) {
        this.genre = genre;
    }

    @Override
    public void filter(Vector<Event> eventi) {
        Iterator<Event> iter = eventi.iterator();
        while (iter.hasNext()) {
            Event evento = iter.next(); // Prossimo evento
            if (!evento.getGenre().equals(genre))
                iter.remove();
        }
    }

    @Override
    public void validate() {
        if (genre == null)
            throw new FilterException("Genere non valido!");
    }

}
