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
	 * Questo metodo ritorna una stringa che descrive l'errore
	 * 
	 * @return <code>String</code>
	 */
	public String getMessage() {
		return "Errore, data inserita non valida!(formato accettato 'dd-MM-yyyy')";
	}

}