package it.univpm.progetto.model;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 *         <p>
 *         <b>Classe</b> che definisce l'evento
 *         <p>
 */
public abstract class Event {

    private String id;

    private String name;

    private Dates dates;

    private String info;

    private boolean family;

    private PriceRange priceRange;

    private Venue venue;

    /**
     * <p>
     * Costruttore dell'oggetto evento
     * 
     * @param id     indica l'id dell'evento
     * @param name   indica il nome dell'evento
     * @param info   indica l'info dell'evento
     * @param family indica se l'evento è per famiglie oppure no
     * <p>
     */
    public Event(String id, String name, String info, boolean family) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.family = family;
    }

    public abstract String getGenre();

    /**
     * <p>
     * Ritorna l'id dell'evento
     * 
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
     * Ritorna il nome dell'evento
     * 
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
     * 
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
     * 
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
     * Ritorna se è un evento per famiglie
     * 
     * @return family
     * <p>
     */
    public boolean isFamily() {
        return family;
    }
    /**
     * 
     * @param family indica se è per famiglie
     * 
     */
    public void setFamily(boolean family) {
        this.family = family;
    }

    /**
     * <p>
     * Ritorna la fascia di prezzo dell'evento
     * 
     * @return priceRange
     *         <p>
     */
    public PriceRange getPriceRange() {
        return priceRange;
    }

    /**
     * 
     * @param priceRange indica la fascia di prezzo dell'evento
     * 
     */
    public void setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
    }

    /**
     * <p>
     * Definisce la località in cui si svolge l'evento
     * 
     * @return venue
     *         <p>
     */
    public Venue getVenue() {
        return venue;
    }

    /**
     * 
     * @param venue indica la località in cui si svolge l'evento
     * 
     */
    public void setVenue(Venue venue) {
        this.venue = venue;
    }

}