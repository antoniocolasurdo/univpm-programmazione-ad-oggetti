package it.univpm.progetto.exception;

/**
 *<p>
 *L'eccezione <b>WrongGenreException</b> estende <b>Exception</b>.
 *Questa viene generata quando l'utente inserisce un genere non presente oppure scritto in modo erroneo
 *</p>
 *
 * 
 */
public class WrongGenreException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4715219300727131647L;

	/**
	 * Costruttore della classe <b>WrongGenreException</b>
	 */
	public WrongGenreException() {
		super();
	}
	
    /**
     * Costruttore
     * 
     * @param message messaggio d'errore
     */
    public WrongGenreException(String message) {
        super(message);
    }

	/**
	 * <p>Questo metodo ritorna una stringa che descrive l'errore<p>
	 * 
	 * @return <code>String</code>
	 */
	@Override
	public String getMessage() {
		return "Errore, il genere inserito non è valido!";
	}

}