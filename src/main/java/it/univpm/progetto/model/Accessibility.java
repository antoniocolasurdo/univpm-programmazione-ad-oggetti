package it.univpm.progetto.model;


/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * Classe che definisce i parametri di accessibilità
 */
public class Accessibility {

	/**
	 * Numero di ticket massimo acquistabile da un singolo utente
	 */
	private int ticketLimit;
	
	public int getTicketLimit() {
		return ticketLimit;
	}
	public void setTicketLimit(int ticketLimit) {
		this.ticketLimit = ticketLimit;
	}

}