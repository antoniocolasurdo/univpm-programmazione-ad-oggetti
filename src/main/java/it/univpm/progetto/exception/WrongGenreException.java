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

	public WrongGenreException(String string) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Questo metodo ritorna una stringa che descrive l'errore
	 * 
	 * @return <code>String</code>
	 */
	@Override
	public String getMessage() {
		return "Errore, il genere inserito non è valido!";
	}

}