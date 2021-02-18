package it.univpm.progetto.filter;

import java.util.Iterator;
import java.util.Vector;
import it.univpm.progetto.exception.WrongSegmentException;
import it.univpm.progetto.model.ArtsAndTheatreEvent;
import it.univpm.progetto.model.Event;
import it.univpm.progetto.model.MiscellaneousEvent;
import it.univpm.progetto.model.MusicEvent;
import it.univpm.progetto.model.SportEvent;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p><b>Classe</b> che modella il filtro sulle classificazioni
 * (Music, Sports, Art e Theatre, Miscellaneous) sui vari generi e sottogeneri
 * estendendo la superclasse Filter.</p>
 * 
 */
public class SegmentFilter extends Filter {

    /**
     * TODO
     * SEGMENTI INSERIBILI DALL'UTENTE (da mettere nel README): {sport, music, theatre, generic}
     */
	private String[] filteredSegments;

    /**
     * Costruttore
     * 
     * @param segment classificazione degli eventi
     */
    public SegmentFilter(String segment) {
        super();
        this.filteredSegments = segment.toLowerCase().split(",");
    }

    @Override
    public void filter(Vector<Event> eventi) {
        Iterator<Event> iter = eventi.iterator();

        while (iter.hasNext()) {
        	Event user = iter.next();

        	boolean found = false;

        	for (int index = 0; index < filteredSegments.length; index++) {

        		switch (filteredSegments[index]) {

        		case "music":
                    if (user instanceof MusicEvent) {
                        found = true;
                    }
                    break;


        		case "sport":
                    if (user instanceof SportEvent) {
                        found = true;
                    }
                    break;


        		case "theatre":
                    if (user instanceof ArtsAndTheatreEvent) {
                    	found = true;
                    }
                    break;


        		case "miscellaneous":
                    if (user instanceof MiscellaneousEvent) {
                        found = true;
                    }
                    break;
                }
            }

        	if (!found) {
            	iter.remove();
            }
        }
    }

    // Recupera le eccezioni di classificazioni filtrate errate
    @Override
    public void validate() throws WrongSegmentException {
    	for (int index = 0; index < filteredSegments.length; index++) {
            if (!(filteredSegments[index].equals("sport") || filteredSegments[index].equals("music") ||
            		filteredSegments[index].equals("theatre") || filteredSegments[index].equals("miscellaneous")))
                throw new WrongSegmentException("Tipo inserito non valido (ammessi 'sport', 'music', 'theatre','miscellaneous')");
    	}
    }

}
