package Filter;

import it.univpm.progetto.model.MiscellaneousEvent;
import it.univpm.progetto.model.MusicEvent;
import it.univpm.progetto.model.SportEvent;
import it.univpm.progetto.model.ArtsAndTheatreEvent;
import it.univpm.progetto.model.Event;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe</b> che modella il filtro sulle classificazioni (Music,Sports,Art&Theatre,Miscellaneous), sui vari generi e sottogeneri,
 * <b> estendendo la superclasse Filter. 
 * <p>
 */

public class ClassificationFilter extends Filter {

	/**
     * Attributo su cui si basa il filtraggio
     */
    private String Segment;
    
    /**
     * Costruttore
     * 
     * @param sewgment
     */
    public ClassificationFilter(String segment) {
        super();
        this.segment = segment;
    }
    
    @Override
    public void filter(Vector<Event> event) {
        Iterator<Event> iter = event.iterator();
        switch (segment) {
        case "music":
            while (iter.hasNext()) {
                Event user = iter.next(); // Prossimo utente
                if (!(user instanceof MusicEvent))
                    iter.remove();
            }
            break;

        case "sport":
            while (iter.hasNext()) {
                Event user = iter.next(); // Prossimo utente
                if (!(user instanceof SportEvent))
                    iter.remove();
            }
            break;

        case "theatre":
            while (iter.hasNext()) {
                Event user = iter.next(); // Prossimo utente
                if (!(user instanceof ArtsAndTheatreEvent))
                    iter.remove();
            }
            break;
            
        case "miscellaneous":
            while (iter.hasNext()) {
                Event user = iter.next(); // Prossimo utente
                if (!(user instanceof MiscellaneousEvent))
                    iter.remove();
            }
            break;
        }

    }
    
    @Override
    public void validate() {
        if (!(tipo.equals("sport") || tipo.equals("music") || tipo.equals("theatre") || tipo.equals("miscellaneous")))
            throw new FilterArgumentException("Tipo inserito non valido (ammessi 'sport', 'music', 'theatre','miscellaneous')");
    }
}



