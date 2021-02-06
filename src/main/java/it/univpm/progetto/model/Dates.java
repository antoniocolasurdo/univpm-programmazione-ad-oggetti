package it.univpm.progetto.model;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * Classe che definisce le date degli eventi
 */
public class Dates {

	private LocalDate localDate;
	private LocalTime localTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private DateTime dateTime;

    public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	public LocalTime getLocalTime() {
		return localTime;
	}
	public void setLocalTime(LocalTime localTime) {
		this.localTime = localTime;
	}
	public DateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}

}