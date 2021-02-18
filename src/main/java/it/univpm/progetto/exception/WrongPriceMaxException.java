package it.univpm.progetto.exception;

/**
 *<p>
 *L'eccezione <b>WrongPriceMaxException</b> estende <b>Exception</b>.
 *Questa viene generata quando l'utente inserisce un prezzo massimo che è minore di quello minimo
 *</p>
 *
 * 
 */
public class WrongPriceMaxException extends Exception {


	private static final long serialVersionUID = 471995985727155647L ;

	/**
	 * Costruttore della classe <b>WrongPriceMaxException</b>
	 */
	public WrongPriceMaxException() {
		super();
	}
	
    /**
     * Costruttore
     * 
     * @param message messaggio d'errore
     */
    public WrongPriceMaxException(String message) {
        super(message);
    }
	
	/**
	 * <p>Questo metodo ritorna una stringa che descrive l'errore<p>
	 * 
	 * @return <code>String</code>
	 */
	@Override
	public String getMessage() {
		return "Errore, il prezzo massimo non può essere minore di quello minimo";
	}

}