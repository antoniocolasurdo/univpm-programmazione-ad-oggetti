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
 *<p>
 *<b>Classe</b> che modella il filtro sulle classificazioni
 *(Music,Sports,Art&Theatre,Miscellaneous), sui vari generi e sottogeneri,
 *<b> estendendo la superclasse Filter.
 *<p>
 */

public class SegmentFilter extends Filter {

    /**
     * TODO
     * SEGMENTI INSERIBILI DALL'UTENTE (da mettere nel README): {sport, music, theatre, generic}
     */
    private String segment;

    /**
     * Costruttore
     * 
     * @param segment
     */
    public SegmentFilter(String segment) {
        super();
        this.segment = segment;
    }

    @Override
    public void filter(Vector<Event> event) {
        Iterator<Event> iter = event.iterator();
        switch (segment) {
        case "music":
            while (iter.hasNext()) {
                Event user = iter.next(); // Prossimo evento
                if (!(user instanceof MusicEvent))
                    iter.remove();
            }
            break;

        case "sport":
            while (iter.hasNext()) {
                Event user = iter.next(); // Prossimo evento
                if (!(user instanceof SportEvent))
                    iter.remove();
            }
            break;

        case "theatre":
            while (iter.hasNext()) {
                Event user = iter.next(); // Prossimo evento
                if (!(user instanceof ArtsAndTheatreEvent))
                    iter.remove();
            }
            break;

        case "miscellaneous":
            while (iter.hasNext()) {
                Event user = iter.next(); // Prossimo evento
                if (!(user instanceof MiscellaneousEvent))
                    iter.remove();
            }
            break;
        }

    }

    @Override
    public void validate() throws WrongSegmentException {
        if (!(segment.equals("sport") || segment.equals("music") || segment.equals("theatre")
                || segment.equals("miscellaneous")))
            throw new WrongSegmentException("Tipo inserito non valido (ammessi 'sport', 'music', 'theatre','miscellaneous')");
    }

}
