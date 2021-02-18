package it.univpm.progetto.exception;

/**
 *<p>
 *L'eccezione <b>GenericException</b> estende <b>Exception</b>.
 *Questa viene generata per prevenire errori non gestiti
 *</p>
 *
 * 
 */
public class GenericException extends Exception {


	private static final long serialVersionUID = -8617215203403825398L;


	private String message;
	
    /**
     * Costruttore
     * 
     * @param message messaggio d'errore
     */
	public GenericException(String message) {
		this.message = message;
	}
	
	/**
	 * <p>Questo metodo ritorna un messaggio dell'errore<p>
	 * 
	 * @return <code>String</code>
	 */
	@Override
	public String getMessage() {
		return message;
	}

}