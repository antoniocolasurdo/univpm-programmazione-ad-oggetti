package it.univpm.progetto.exception;

/**
 *<p>
 *L'eccezione <b>WrongEndDateException</b> estende <b>Exception</b>.
 *Questa viene generata quando l'utente inserisce una data finale inferiore alla data iniziale
 *</p>
 *
 * 
 */
public class WrongEndDateException extends Exception {


	private static final long serialVersionUID = 7081238066265117483L;

	/**
	 * Costruttore della classe <b>WrongEndDateException</b>
	 */
	public WrongEndDateException() {
		super();
	}
	
    /**
     * Costruttore
     * 
     * @param message
     */
    public WrongEndDateException(String message) {
        super(message);
    }
	
	/**
	 * Questo metodo ritorna una stringa che descrive l'errore
	 * 
	 * @return <code>String</code>
	 */
	@Override
	public String getMessage() {
		return "Errore, la data inserita non è valida!";
	}

}