package it.univpm.progetto.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe</b> che definisce l'evento
 * <p>
 */
public class Event {

	private String name;

	private String id;

	private Dates dates;

	private List<Classification> classifications;

	private String info;

	private List<PriceRange> priceRanges;

	private List<Venue> venues;
	
	/**
	 * <p>
	 * Costruttore dell'oggetto evento
	 * <p>
	 */
	public Event() {
		dates = new Dates();
		classifications = new ArrayList<Classification>();
		priceRanges = new ArrayList<PriceRange>();
		venues = new ArrayList<Venue>();
	}
	/**
	 * <p>
	 * Costruttore dell'oggetto evento con parametri
	 * @param name indica il nome dell'evento
	 * @param id indica l'id dell'evento
	 * @param info indica l'info dell'evento
	 * <p>
	 */
	public Event(String name, String id, String info) {
		super();
		this.name = name;
		this.id = id;
		this.info = info;
	}
	/**
	 * <p>
	 * Ritorna il nome dell'evento
	 * @return name
	 * <p>
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name indica il nome dell'evento
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * <p>
	 * Ritorna l'id dell'evento
	 * @return id
	 * <p>
	 */
	public String getId() {
		return id;
	}
	/**
	 * 
	 * @param id indica l'id dell'evento
	 * 
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * <p>
	 * Ritorna la data dell'evento
	 * @return dates
	 * <p>
	 */
	public Dates getDates() {
		return dates;
	}
	/**
	 * 
	 * @param dates indica la data dell'evento
	 * 
	 */
	public void setDates(Dates dates) {
		this.dates = dates;
	}
	/**
	 * <p>
	 * Ritorna la lista delle classificazioni dell'evento
	 * @return classifications
	 * <p>
	 */
	public List<Classification> getClassifications() {
		return classifications;
	}
	/**
	 * 
	 * @param classifications indica la lista delle classificazioni
	 * 
	 */
	public void setClassifications(List<Classification> classifications) {
		this.classifications = classifications;
	}
	/**
	 * <p>
	 * Ritorna le info dell'evento
	 * @return info
	 * <p>
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * 
	 * @param info indica le info dell'evento
	 * 
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * <p>
	 * Ritorna la lista delle fasce di prezzo dell'evento
	 * @return priceRanges
	 * <p>
	 */
	public List<PriceRange> getPriceRanges() {
		return priceRanges;
	}
	/**
	 * 
	 * @param priceRanges indica la lista delle fasce di prezzo dell'evento
	 * 
	 */
	public void setPriceRanges(List<PriceRange> priceRanges) {
		this.priceRanges = priceRanges;
	}
	/**
	 * <p>
	 * Definisce la lista delle località in cui si svolge l'evento
	 * @return venues
	 * <p>
	 */
	public List<Venue> getVenues() {
		return venues;
	}
	/**
	 * 
	 * @param venues indica la lista delle località in cui si svolge l'evento
	 * 
	 */
	public void setVenues(List<Venue> venues) {
		this.venues = venues;
	}

}