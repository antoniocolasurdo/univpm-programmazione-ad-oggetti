package Filter;

import java.text.SimpleDateFormat;
import it.univpm.progetto.model.Dates;
import it.univpm.progetto.model.Event;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe</b> che modella il filtro sulle date, estendendo la superclasse Filter. 
 * <b>utilizzando 2 valori di filtraggio, uno per l'estremo inferiore dell'intervallo StartDate, uno per l'estremo superiore dell'intervallo EndDate.
 * <p>
 */

public class DateFilter extends Filter {

    /**
     * Valori di intervallo di data
     */
	private String StartDate; 
	private String EndDate;
	
    /**
     * Oggetto formattatore di date
     */
    SimpleDateFormat df;
	
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
        df = new SimpleDateFormat ("dd-MM-yyyy");
    }
    
    /**
     *@Override
     */
    
    public void filter(Dates dates) {
        // Crea le date a partire dalle stringhe
        Dates from = null;
        Dates to = null;
        try {
            if (StartDate != null)
                from = df.parse(StartDate);
            if (EndDate != null)
                to = df.parse(EndDate);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        
        /**
         *@Override
         */
        
        public void validate() {
            Dates from = null, to = null;
            try {
                if (StartDate != null)
                    from = df.parse(StartDate);
                if (EndDate != null)
                    to = df.parse(EndDate);
            }
            catch (ParseException e) {
                throw new FilterArgumentException("Date inserite non valide (formato accettato 'dd-MM-yyyy')");
            }
            if (from != null && to != null && to.compareTo(from) < 0)
                throw new FilterArgumentException("La data finale non può essere precedente a quella iniziale");
        }

}
