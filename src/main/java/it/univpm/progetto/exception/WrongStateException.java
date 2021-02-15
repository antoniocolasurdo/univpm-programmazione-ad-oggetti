package it.univpm.progetto.exception;

/**
 *<p>
 *L'eccezione <b>WrongStateException</b> estende <b>Exception</b>.
 *Questa viene generata quando l'utente inserisce un nome errato per il codice dello stato
 *</p>
 *
 * 
 */

public class WrongStateException extends Exception {

	private static final long serialVersionUID = 371795985727177677L;
	
    /**
     * Costruttore della classe <b>WrongStateException</b>
	 */
	public WrongStateException() {
	super();
	}
	
    /**
     * Costruttore
     * 
     * @param message
     */
    public WrongStateException(String message) {
        super(message);
    }
    
	/**
	 * Questo metodo ritorna una stringa che descrive l'errore
	 * 
	 * @return <code>String</code>
	 */
	public String getMessage() {
		return "Errore, il codice dello stato inserito non è valido!";
	}
}