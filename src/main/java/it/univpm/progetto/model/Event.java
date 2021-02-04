package it.univpm.progetto.model;

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
	 * Definisce il tipo dell'evento
	 */
	private String type;
	/**
	 * Definisce l'id dell'evento
	 */
	private String id;
	/**
	 * Definisce il test dell'evento
	 */
	private boolean test;
	/**
	 * Definisce l'URL dell'evento
	 */
	private String url;
	/**
	 * Definisce la località dell'evento
	 */
	private String locale;
	/**
	 * Definisce la lista di immagini dell'evento
	 */
	private List<Image> images;
	/**
	 * Definisce i saldi dell'evento
	 */
	private Sales sales;
	/**
	 * Definisce le date dell'evento
	 */
	private Dates dates;
	/**
	 * Definisce la lista delle classificazioni dell'evento
	 */
	private List<Classification> classifications;
	/**
	 * Definisce lo sponsor dell'evento
	 */
	private Promoter promoter;
	/**
	 * Definisce la lista degli sponsor dell'evento
	 */
	private List<Promoter> promoters;
	/**
	 * Definisce le informazioni dell'evento
	 */
	private String info;
	/**
	 * Definisce le note dell'evento
	 */
	private String pleaseNote;
	/**
	 * Definisce la lista della fascia di prezzo
	 */
	private List<PriceRange> priceRanges;
	/**
	 * Definisce la lista dei prodotti
	 */
	private List<Product> products;
	/**
	 * Definisce la mappa dei posti
	 */
	private SeatMap seatMap;
	/**
	 * Definisce l'accessibilità
	 */
	private Accessibility accessibility;
	/**
	 * Definisce il numero di ticket massimi acquistabili da un singolo utente
	 */
	private TicketLimit ticketLimit;
	/**
	 * Definisce i limiti di età
	 */
	private AgeRestrictions ageRestrictions;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isTest() {
		return test;
	}
	public void setTest(boolean test) {
		this.test = test;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public Sales getSales() {
		return sales;
	}
	public void setSales(Sales sales) {
		this.sales = sales;
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
	public Promoter getPromoter() {
		return promoter;
	}
	public void setPromoter(Promoter promoter) {
		this.promoter = promoter;
	}
	public List<Promoter> getPromoters() {
		return promoters;
	}
	public void setPromoters(List<Promoter> promoters) {
		this.promoters = promoters;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getPleaseNote() {
		return pleaseNote;
	}
	public void setPleaseNote(String pleaseNote) {
		this.pleaseNote = pleaseNote;
	}
	public List<PriceRange> getPriceRanges() {
		return priceRanges;
	}
	public void setPriceRanges(List<PriceRange> priceRanges) {
		this.priceRanges = priceRanges;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public SeatMap getSeatMap() {
		return seatMap;
	}
	public void setSeatMap(SeatMap seatMap) {
		this.seatMap = seatMap;
	}
	public Accessibility getAccessibility() {
		return accessibility;
	}
	public void setAccessibility(Accessibility accessibility) {
		this.accessibility = accessibility;
	}
	public TicketLimit getTicketLimit() {
		return ticketLimit;
	}
	public void setTicketLimit(TicketLimit ticketLimit) {
		this.ticketLimit = ticketLimit;
	}
	public AgeRestrictions getAgeRestrictions() {
		return ageRestrictions;
	}
	public void setAgeRestrictions(AgeRestrictions ageRestrictions) {
		this.ageRestrictions = ageRestrictions;
	}

}