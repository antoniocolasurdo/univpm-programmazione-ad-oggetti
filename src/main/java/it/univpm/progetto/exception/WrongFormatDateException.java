package it.univpm.progetto.exception;

/**
 *<p>
 *L'eccezione <b>WrongFormatDateException</b> estende <b>Exception</b>.
 *Questa viene generata quando l'utente inserisce una data in un formato non valido
 *</p>
 *
 * 
 */
public class WrongFormatDateException extends Exception {


	private static final long serialVersionUID = 2919461406893831616L;

	/**
	 * Costruttore della classe <b>WrongFormatDateException</b>
	 */
	public WrongFormatDateException() {
		super();
	}
	
    /**
     * Costruttore
     * 
     * @param message messaggio d'errore
     */
    public WrongFormatDateException(String message) {
        super(message);
    }
	
	/**
	 * <p>Questo metodo ritorna una stringa che descrive l'errore<p>
	 * 
	 * @return <code>String</code>
	 */
	@Override
	public String getMessage() {
		return "Errore, data inserita non valida!(formato accettato 'dd-MM-yyyy')";
	}

}