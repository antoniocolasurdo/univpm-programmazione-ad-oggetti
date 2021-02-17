package it.univpm.progetto.exception;

/**
 *<p>
 *L'eccezione <b>WrongStartDateException</b> estende <b>Exception</b>.
 *Questa viene generata quando l'utente inserisce una data inferiore alla lettura dei dati di TicketMaster
 *</p>
 *
 * 
 */
public class WrongStartDateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7567034279474083291L;

	/**
	 * Costruttore della classe <b>WrongStartDateException</b>
	 */
	public WrongStartDateException() {
		super();
	}
	
    /**
     * Costruttore
     * 
     * @param message
     */
    public WrongStartDateException(String message) {
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