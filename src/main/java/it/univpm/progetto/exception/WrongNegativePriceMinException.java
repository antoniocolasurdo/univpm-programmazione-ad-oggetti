package it.univpm.progetto.exception;

/**
 *<p>
 *L'eccezione <b>WrongNegativePriceMinException</b> estende <b>Exception</b>.
 *Questa viene generata quando l'utente inserisce un prezzo minimo minore di 0
 *</p>
 *
 * 
 */
public class WrongNegativePriceMinException extends Exception {


	private static final long serialVersionUID = 4719919380727151647L;

	/**
	 * Costruttore della classe <b>WrongNegativePriceMinException</b>
	 */
	public WrongNegativePriceMinException() {
		super();
	}
	
    /**
     * Costruttore
     * 
     * @param message
     */
    public WrongNegativePriceMinException(String message) {
        super(message);
    }
	
	/**
	 * Questo metodo ritorna una stringa che descrive l'errore
	 * 
	 * @return <code>String</code>
	 */
	@Override
	public String getMessage() {
		return "Errore, il prezzo minimo non può essere minore di 0";
	}

}