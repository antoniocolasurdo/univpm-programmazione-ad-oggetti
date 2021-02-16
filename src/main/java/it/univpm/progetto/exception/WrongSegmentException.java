package it.univpm.progetto.exception;

/**
 *<p>
 *L'eccezione <b>WrongSegmentException</b> estende <b>Exception</b>.
 *Questa viene generata quando l'utente inserisce un nome errato per il segment
 *</p>
 *
 * 
 */

public class WrongSegmentException extends Exception {

	private static final long serialVersionUID = 471795985727177677L;
	
    /**
     * Costruttore della classe <b>WrongSegmentException</b>
	 */
	public WrongSegmentException() {
	super();
	}
	
    /**
     * Costruttore
     * 
     * @param message
     */
    public WrongSegmentException(String message) {
        super(message);
    }
    
	/**
	 * Questo metodo ritorna una stringa che descrive l'errore
	 * 
	 * @return <code>String</code>
	 */
	@Override
	public String getMessage() {
		return "Tipo inserito non valido (ammessi 'sport', 'music', 'theatre','miscellaneous')";
	}
}
