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

    private String[] filteredStateCodes;

    public StateFilter(String stateCode) {
        super();
        this.filteredStateCodes = stateCode.toUpperCase().split(",");
    }

    @Override
    public void filter(Vector<Event> eventi) {
        Iterator<Event> iter = eventi.iterator();

        while (iter.hasNext()) {
        	Event user = iter.next();
        	
        	boolean found = false;
        	if (user.getVenue() != null && user.getVenue().getStateCode() != null) {
            	for (int index = 0; index < filteredStateCodes.length; index++) {
                    if (user.getVenue().getStateCode().equalsIgnoreCase(filteredStateCodes[index])) {
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
    public void validate() throws WrongStateException {
    	for (int index = 0; index < filteredStateCodes.length; index++) {
            if (filteredStateCodes[index].length() < 2 || filteredStateCodes[index].length() > 3)
                throw new WrongStateException("Codice dello stato non valido, ammessi solo valori alfanumerici di 2 o 3 caratteri!");
    	}
    }

}