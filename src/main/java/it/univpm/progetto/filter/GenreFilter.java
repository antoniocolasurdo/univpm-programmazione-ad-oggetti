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

	private String[] filteredGenres;

    public GenreFilter(String genre) {
    	super();
        this.filteredGenres = genre.toLowerCase().split(",");
    }

    @Override
    public void filter(Vector<Event> eventi) {
        Iterator<Event> iter = eventi.iterator();

        while (iter.hasNext()) {
        	Event evento = iter.next();
        	
        	boolean found = false;
        	if (evento.getGenre() != null) {
            	for (int index = 0; index < filteredGenres.length; index++) {
                    if (evento.getGenre().equalsIgnoreCase(filteredGenres[index])) {
                    	found = true;
                    }
            	}
        	}
        	
            if (!found) {
            	iter.remove();
            }
        }
    }

    @Override
    public void validate() throws WrongGenreException {
    	for (int index = 0; index < filteredGenres.length; index++) {
            if (filteredGenres[index].isEmpty()) {
                throw new WrongGenreException("Genere non valido!");
            }
        }
    }

}