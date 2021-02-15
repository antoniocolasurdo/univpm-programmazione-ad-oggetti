package it.univpm.progetto.filter;

import java.util.Iterator;
import java.util.Vector;

import it.univpm.progetto.model.Event;
import it.univpm.progetto.exception.*;
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
    public void validate() throws WrongGenreException {
        if (genre == null)
            throw new WrongGenreException("Genere non valido!");
    }

}
