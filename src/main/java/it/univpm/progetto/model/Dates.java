package it.univpm.progetto.model;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * Classe che definisce le date degli eventi
 */
public class Dates {
	/**
	 * Definisce l'inizio dell'evento
	 */
	private Start start;
	/**
	 * Definisce la data dell'inizio dell'evento
	 */
	private StartDate initialStartDate;
	/**
	 * Definisce il fuso orario
	 */
	private String timezone;
	/**
	 * Definisce lo stato dell'evento
	 */
	private Status status;
	/**
	 * Definisce se si estende per più giorni
	 */
	private boolean spanMultipleDays;

	public Start getStart() {
		return start;
	}
	public void setStart(Start start) {
		this.start = start;
	}
	public StartDate getInitialStartDate() {
		return initialStartDate;
	}
	public void setInitialStartDate(StartDate initialStartDate) {
		this.initialStartDate = initialStartDate;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public boolean isSpanMultipleDays() {
		return spanMultipleDays;
	}
	public void setSpanMultipleDays(boolean spanMultipleDays) {
		this.spanMultipleDays = spanMultipleDays;
	}

}