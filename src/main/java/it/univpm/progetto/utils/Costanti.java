package it.univpm.progetto.utils;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * Classe contenente tutti i valori costanti utilizzati dal progetto
 */
public class Costanti {

	/**
    * Definizione dei parametri di accesso agli eventi del sito Ticket Master richiesto nel progetto
    */
    public final static String TICKET_MASTER_URL = "https://app.ticketmaster.com/discovery/v2/events.json";
    public final static String COUNTRY_FILTER = "US";
    public final static String API_KEY = "pgAP0yglhrdbzvXSQem3WrDfGpwywPaw";

    /**
    * Definizione della cartella e del nome file sul quale vengono scritti gli eventi recuperati da Ticker Master
    */
    public final static String RESOURCE_PATH = "src/main/resources";
    public final static String RESOURCE_FILENAME = "/ticket_master_events.json";

}