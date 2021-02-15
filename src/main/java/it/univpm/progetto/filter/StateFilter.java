package it.univpm.progetto.filter;

import java.util.Iterator;
import java.util.Vector;
import it.univpm.progetto.exception.WrongStateException;
import it.univpm.progetto.model.Event;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe</b> che modella il filtro sugli stati degli eventi, estendendo la superclasse Filter.
 * <p>
 */

public class StateFilter extends Filter {

    private String stateCode;

    public StateFilter(String stateCode) {
        this.stateCode = stateCode;
    }

    @Override
    public void filter(Vector<Event> eventi) {

        Iterator<Event> iter = eventi.iterator();
        while (iter.hasNext()) {
            Event evento = iter.next(); // Prossimo evento
            if (!evento.getVenue().getStateCode().equals(stateCode))
                iter.remove();
        }
    }

    @Override
    public void validate() throws WrongStateException {
        if (stateCode == null && stateCode.length() != 2)
            throw new WrongStateException("Codice dello stato non valido!");

    }

}
