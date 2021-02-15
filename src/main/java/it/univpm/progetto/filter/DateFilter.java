package it.univpm.progetto.filter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Vector;

import it.univpm.progetto.model.Event;
import it.univpm.progetto.exception.*;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 *         <p>
 *         <b>Classe</b> che modella il filtro sulle date, estendendo la superclasse Filter.
 *         <b>utilizzando 2 valori di filtraggio, uno per l'estremo inferiore dell'intervallo
 *         StartDate, uno per l'estremo superiore dell'intervallo EndDate.
 *         <p>
 */

public class DateFilter extends Filter {

    /**
     * Valori di intervallo di data
     */
    private String StartDate;
    private String EndDate;
    LocalDate lt = LocalDate.now();
    /**
     * Oggetto formattatore di date
     */
    DateTimeFormatter dtf;

    /**
     * Costruttore
     * 
     * @param StartDate
     * @param EndDate
     */
    public DateFilter(String StartDate, String EndDate) {
        super();
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    @Override
    public void filter(Vector<Event> eventi) {

        // Crea le date a partire dalle stringhe
        LocalDate from = null, to = null;

        if (StartDate != null)
            from = LocalDate.parse(StartDate, dtf);
        if (EndDate != null)
            to = LocalDate.parse(EndDate, dtf);

        // Ordina gli eventi in ordine cronologico
        eventi.sort((e1, e2) -> e1.getDates().getLocalDate().compareTo(e2.getDates().getLocalDate()));
        // Istanzia un nuovo iteratore

        if (StartDate != null) {
            Iterator<Event> iter = eventi.iterator();
            while (iter.hasNext()) {
                Event event = iter.next(); // Prossima misurazione
                if (event.getDates().getLocalDate().isBefore(from)) // Data evento precedente alla minima richiesta
                    iter.remove();
                else
                    break;
            }
        }
        if (EndDate != null) {
            Iterator<Event> iter = eventi.iterator();
            while (iter.hasNext()) {
                Event event = iter.next(); // Prossima misurazione
                if (event.getDates().getLocalDate().isAfter(to)) // Data evento successiva alla massima richiesta
                    iter.remove();
                else
                    break;
            }
        }
    }

    @Override
    public void validate() throws WrongEndDateException, WrongFormatDateException, WrongStartDateException {
        LocalDate from = null, to = null;
        try {
            if (StartDate != null)
                from = LocalDate.parse(StartDate, dtf);
            if (EndDate != null)
                to = LocalDate.parse(EndDate, dtf);
        }
        catch (Exception e) {
            throw new WrongFormatDateException("Date inserite non valide (formato accettato 'dd-MM-yyyy')");
        }
        if (from != null && to != null && to.compareTo(from) < 0)
            throw new WrongEndDateException("La data finale non può essere precedente a quella iniziale");
		if (from.compareTo(lt)<0)
        	throw new WrongStartDateException("La data iniziale non può essere precedente alla data corrente");
    }

}
