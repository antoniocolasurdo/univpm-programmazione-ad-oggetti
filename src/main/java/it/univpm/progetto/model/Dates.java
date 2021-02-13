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


	private String Date;

	private String Time;


	/**
	 * <p>
	 * Ritorna la data locale dell'evento
	 * @return Date
	 * <p>
	 */
    public String getDate() {
		return Date;
	}
    /**
	 * 
	 * @param localDate indica la data dell'evento
	 * 
	 */
	public void setDate(String Date) {
		this.Date = Date;
	}
	/**
	 * <p>
	 * Ritorna l'orario locale dell'evento
	 * @return Time
	 * <p>
	 */
	public String getTime() {
		return Time;
	}
	/**
	 * 
	 * @param Time indica l'orario dell'evento
	 * 
	 */
	public void setTime(String Time) {
		this.Time = Time;
	}
}