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

	private String id;
	
	private String name;

	private Dates dates;

	private String info;

	private boolean family;
	
	private List<PriceRange> priceRanges;

	private List<Venue> venues;
	
	/**
	 * <p>
	 * Costruttore dell'oggetto evento
	 * <p>
	 */
	public Event() {
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
	public Event(String id, String name, String info, boolean family) {
		this();
		this.id = id;
		this.name = name;
		this.info = info;
		this.family = family;
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
	}	/**
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
	public boolean isFamily() {
		return family;
	}
	public void setFamily(boolean family) {
		this.family = family;
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