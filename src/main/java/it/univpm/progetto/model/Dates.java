package it.univpm.progetto.model;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe</b> che definisce le date degli eventi
 * <p>
 */
public class Dates {


	private LocalDate localDate;

	private LocalTime localTime;

	private DateTime dateTime;

	/**
	 * <p>
	 * Ritorna la data locale dell'evento
	 * @return localDate
	 * <p>
	 */
    public LocalDate getLocalDate() {
		return localDate;
	}
    /**
	 * 
	 * @param localDate indica la data dell'evento
	 * 
	 */
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	/**
	 * <p>
	 * Ritorna l'orario locale dell'evento
	 * @return localTime
	 * <p>
	 */
	public LocalTime getLocalTime() {
		return localTime;
	}
	/**
	 * 
	 * @param localTime indica l'orario dell'evento
	 * 
	 */
	public void setLocalTime(LocalTime localTime) {
		this.localTime = localTime;
	}
	/**
	 * <p>
	 * Ritorna la data e l'orario dell'evento
	 * @return dateTime
	 * <p>
	 */
	public DateTime getDateTime() {
		return dateTime;
	}
	/**
	 * 
	 * @param dateTime indica la data e l'orario dell'evento
	 * 
	 */
	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}

}