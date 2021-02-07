package it.univpm.progetto.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * Classe che definisce l'evento
 */
public class Event {
	/**
	 * Definisce il nome dell'evento
	 */
	private String name;
	/**
	 * Definisce l'id dell'evento
	 */
	private String id;
	/**
	 * Definisce le date dell'evento
	 */
	private Dates dates;
	/**
	 * Definisce la lista delle classificazioni dell'evento
	 */
	private List<Classification> classifications;
	/**
	 * Definisce le informazioni dell'evento
	 */
	private String info;
	/**
	 * Definisce la lista della fascia di prezzo
	 */
	private List<PriceRange> priceRanges;
	/**
	 * Definisce la lista delle sedi degli eventi
	 */
	private List<Venue> venues;
	
	public Event() {
		dates = new Dates();
		classifications = new ArrayList<Classification>();
		priceRanges = new ArrayList<PriceRange>();
		venues = new ArrayList<Venue>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Dates getDates() {
		return dates;
	}
	public void setDates(Dates dates) {
		this.dates = dates;
	}
	public List<Classification> getClassifications() {
		return classifications;
	}
	public void setClassifications(List<Classification> classifications) {
		this.classifications = classifications;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public List<PriceRange> getPriceRanges() {
		return priceRanges;
	}
	public void setPriceRanges(List<PriceRange> priceRanges) {
		this.priceRanges = priceRanges;
	}
	public List<Venue> getVenues() {
		return venues;
	}
	public void setVenues(List<Venue> venues) {
		this.venues = venues;
	}

}