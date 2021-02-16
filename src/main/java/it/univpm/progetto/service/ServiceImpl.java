package it.univpm.progetto.service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import it.univpm.progetto.data.EventsData;
import it.univpm.progetto.exception.GenericException;
import it.univpm.progetto.model.*;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe</b> che implementa tutte le funzioni relative alla lettura dei dati da TicketMaster e li recupera mettendo a disposizione i dati e metadati
 * <p>
 */
@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    /**
     * <p>
     * Logger utilizzato per visualizzare e memorizzare i messaggi di sistema dell'applicazione e per intercettare i messaggi generati dalle eccezioni
     * <p>
     */
	private static final Logger LOG = LoggerFactory.getLogger(ServiceImpl.class);

    /**
     * <p>
     * Oggetto utilizzato per deserializzare i dati ricevuti in formato JSON
     * <p>
     */
	ObjectMapper objectMapper;

    /**
     * <p>
     * Variabili contenenti la configurazione del progetto e che vengono valorizzate quando la classe viene istanziata
     * <p>
     */
    private static String TICKET_MASTER_URL;
    private static String TICKET_MASTER_FILTER;
    private static String TICKET_MASTER_API_KEY;
    private static int PAGES;
    private static int SIZE;
	
    /**
     * <p>
     * @see https://www.baeldung.com/
     * Oggetto RestTemplate utilizzato per accedere all'API Get messa a disposizione da Ticket Master
     * <p>
     */
    @Autowired
    private RestTemplate restTemplate;
	
	public ServiceImpl() {

		// Oggetto di gestione del formato JSON della libreria jackson
		objectMapper = new ObjectMapper();

		// Lista degli eventi caricati da Ticket Master
		//events = new ArrayList<Event>();
		
		// Leggo il file di configurazione contenente tutti i parametri di funzionamento del progetto
		try {
			File configFile = new File("src/main/resources/config.json");
			JsonNode configNode = objectMapper.readTree(configFile);
			TICKET_MASTER_URL = configNode.get("TICKET_MASTER_URL").asText();
			TICKET_MASTER_FILTER = configNode.get("TICKET_MASTER_FILTER").asText();
			TICKET_MASTER_API_KEY = configNode.get("TICKET_MASTER_API_KEY").asText();
			PAGES = configNode.get("PAGES").asInt();
			SIZE = configNode.get("SIZE").asInt();
		} catch (Exception ex) {
			LOG.error(ex.getMessage());
		}
		
	}
	
	/**
     * <p>
     * Funzione di lettura dati per leggere i dati di TicketMaster di un numero <i>PAGES</i> di pagine
     * <p>
	 * @throws Exception 
    */
	@Override
	public void readData() throws GenericException {
		// Svuoto il contenuto della lista degli eventi
		EventsData.getInstance().getEvents().clear();
		
		// Eseguo ciclo in funzione del numero di pagine
    	for (int index = 0; index < PAGES; index ++) {
    		
    		LOG.info("Caricamento dati da Ticket Master, pagina " + index);

    		// Recupero il contenuto dei dati in una risposta contenente una stringa
    		ResponseEntity<String> response = restTemplate.getForEntity(getTicketMasterUrl(index), String.class);

    		// Se la risposta è andata a buon fine (codice 200) carico i dati altrimenti segnalo errore
        	if (response.getStatusCode() == HttpStatus.OK) {
        		String ticketMasterJson = response.getBody();
        		processPage(ticketMasterJson);
        	}
        	else {
        		LOG.error("Errore nel recupero dei dati da Ticket Master, statusCode: " + response.getStatusCodeValue());
        	}
    	}
		LOG.info("Caricamento dati da Ticket Master avvenuto correttamente!");

	}

	/**
     * <p>
     * Metodo di recupero della struttura dei metadati in un oggetto Json
     * <p>
     */
	@Override
	public JsonNode getMetaData() throws GenericException {

		return processClass(Event.class);

	}

	/**
     * <p>
     * Funzione di elaborazione di una classe generica per il recupero dei metadati
     * <p>
     */
	private ObjectNode processClass(Class<?> classe) {

		// Creo il nodo all'interno del quale inserisco i campi della classe
		ObjectNode objectNode = objectMapper.createObjectNode();
		
		// Ciclo sulle proprietà della classe
		Field[] fields = classe.getDeclaredFields();
		for (Field field : fields) {
			
			// Se la proprietà è una List<T> recupero il tipo di dato nella lista
			if (field.getType().getSimpleName().equals("List")) {
				Type type = field.getGenericType();
				if (type instanceof ParameterizedType) {
				    Type elementType = ((ParameterizedType) type).getActualTypeArguments()[0];
				    
				    // Creo un nodo Json di tipo array
				    ArrayNode arrayNode = objectNode.putArray(field.getName());
				    
				    // Creo un sottonodo come primo elemento del nodo array
				    ObjectNode listObjectNode = objectMapper.createObjectNode();
				    listObjectNode.set(((Class<?>)elementType).getSimpleName(), processClass((Class<?>)elementType));
				    arrayNode.add(listObjectNode);
				}
			} else {
				
				// Verifica se la proprietà è un oggetto appartenente alle classi del model
				if (field.getType().getSimpleName().equals("Dates") ||
					field.getType().getSimpleName().equals("Venue") ||
					field.getType().getSimpleName().equals("PriceRange")) {
					
					// Creo un sottonodo con le proprietà contenute nella corrispondente classe
					ObjectNode subNode = objectMapper.createObjectNode();
					subNode.set(field.getType().getSimpleName(), processClass(field.getType()));
					objectNode.set(field.getName(), subNode);
				} else {
					
					// Aggiunta di un nuovo elemento al nodo Json con il nome del campo e la tipologia
					objectNode.put(field.getName(), field.getType().getSimpleName());
				}
			}
			
		}
		
		// Se la classe è derivata da una classe base, elaboro le corrispondenti proprietà
		if (classe.getSuperclass() != null && classe.getSuperclass().getDeclaredFields().length > 0) {
			Field[] superClassFields = classe.getSuperclass().getDeclaredFields();
			for (Field superClassfield : superClassFields) {
				objectNode.put(superClassfield.getName(), superClassfield.getType().getSimpleName());
			}
			
		}
		
		return objectNode;

	}
	
	/**
     * <p>
     * Metodo di recupero di tutti i dati che sono stati recuperati da Ticket Master
     * <p>
     */
	@Override
	public List<Event> getData() throws GenericException {
		return EventsData.getInstance().getEvents(); //events;
	}

	
	/**
	 * <p>
	 * Funzione di costruzione della URL che accede a Ticket Master in base al numero di pagina
	 * <p>
	 */
	private String getTicketMasterUrl(int page) {
    	String result = "";
    	
    	result += TICKET_MASTER_URL;
    	result += "?" + TICKET_MASTER_FILTER;
    	result += "&" + TICKET_MASTER_API_KEY;
    	result += "&page=" + page;
    	result += "&size=" + SIZE;
    	
    	return result;
	}
	
	/**
	 * <p>
	 * Funzione di elaborazione dei dati della pagina inserendo i record recuperati nel modello dati
	 * <p>
	 */
	private void processPage(String ticketMasterData) throws GenericException {
		
		try {
			// Elaboro il nodo radice
			JsonNode rootNode = objectMapper.readTree(ticketMasterData);

			// Il nodo radice contiene sempre un sottonodo chiamato "_embedded"
			if (rootNode.has("_embedded")) {
				JsonNode embeddedNode = rootNode.get("_embedded");
			
				// Elaboro la lista degli eventi nel nodo array chiamato "events"
				if (embeddedNode.has("events")) {
					JsonNode eventsNode = embeddedNode.get("events");

					if (eventsNode.isArray()) {

						// Ciclo su ogni evento recuperato
						for (JsonNode eventNode : eventsNode) {
							
							// Leggo le proprietà principali
							String eventId = eventNode.get("id").asText();
							String eventName = eventNode.get("name").asText();
							String eventInfo = eventNode.hasNonNull("info") ? eventNode.get("info").asText() : null;
							boolean eventFamily = false;
							
							// Elaborazione del sottoramo dates contenente le date dell'evento
							LocalDate localDate = null;
							LocalTime localTime = null;
							if (eventNode.has("dates")) {
								JsonNode datesNode = eventNode.get("dates");
								if (datesNode.has("start")) {
									JsonNode startNode = datesNode.get("start");
									if (startNode.has("localDate")) {
										if (startNode.get("localDate").asText() != null) {
											localDate = LocalDate.parse(startNode.get("localDate").asText());
										}
									}
									if (startNode.has("localTime")) {
										if (startNode.get("localTime").asText() != null) {
											localTime = LocalTime.parse(startNode.get("localTime").asText());
										}
									}
								}
							}
							Dates dates = new Dates(localDate, localTime);

							// Elaborazione del sottoramo priceRanges
							JsonNode priceRangesNode = null;
							if (eventNode.has("priceRanges")) {
								priceRangesNode = eventNode.get("priceRanges");
							}

							// Nel ramo _emdebbed vi sono gli altri oggetti dichiarati nel data model di Ticket Master
							JsonNode venuesNode = null;
							if (eventNode.has("_embedded")) {
								JsonNode embeddedEventNode = eventNode.get("_embedded");
								
								// Elaborazione del sottonodo venues contenente un'array di località in cui si svolge l'evento
								if (embeddedEventNode.has("venues")) {
									venuesNode = embeddedEventNode.get("venues");
								}
							}

							// Elaborazione del sottoramo classifications e verifico se la tipologia è Music, Sport, ArtsAndThaetre e Miscellaneous
							if (eventNode.has("classifications")) {
								JsonNode classificationsNode = eventNode.get("classifications");
								for (JsonNode classificationNode : classificationsNode) {

									// Leggo se evento per famiglia
									if (classificationNode.has("family")) {
										eventFamily = classificationNode.get("family").asBoolean();
									}

									// Leggo il genere ed il sottogenere
									String genre = null;
									String subGenre = null;
									
									// Recupero il genere
									if (classificationNode.has("genre")) {
										JsonNode genreNode = classificationNode.get("genre");
										genre = genreNode.get("name").asText();
									}
									
									// Recupero il sottogenere
									if (classificationNode.has("subGenre")) {
										JsonNode subGenreNode = classificationNode.get("subGenre");
										subGenre = subGenreNode.get("name").asText();
									}
									
									// Recupero la classe di classificazione dell'evento
									if (classificationNode.has("segment")) {
										JsonNode segmentNode = classificationNode.get("segment");
										String segmentName = segmentNode.get("name").asText();
										
										switch (segmentName) {
											case "Music":
											{
												MusicEvent musicEvent = new MusicEvent(eventId, eventName, eventInfo, eventFamily, genre, subGenre);
												if (dates != null)
												{
													musicEvent.setDates(dates);
												}
												if (priceRangesNode != null) {
													processPriceRanges(musicEvent, priceRangesNode);
												}
												if (venuesNode != null) {
													processVenues(musicEvent, venuesNode);
												}
												//events.add(musicEvent);
												EventsData.getInstance().getEvents().add(musicEvent);
												break;
											}
											case "Arts & Theatre":
											{
												ArtsAndTheatreEvent artsAndTheatreEvent = new ArtsAndTheatreEvent(eventId, eventName, eventInfo, eventFamily, genre, subGenre);
												if (dates != null)
												{
													artsAndTheatreEvent.setDates(dates);
												}
												if (priceRangesNode != null) {
													processPriceRanges(artsAndTheatreEvent, priceRangesNode);
												}
												if (venuesNode != null) {
													processVenues(artsAndTheatreEvent, venuesNode);
												}
												EventsData.getInstance().getEvents().add(artsAndTheatreEvent);
												break;
											}
											case "Sports":
											{
												SportEvent sportEvent = new SportEvent(eventId, eventName, eventInfo, eventFamily, genre);
												if (dates != null)
												{
													sportEvent.setDates(dates);
												}
												if (priceRangesNode != null) {
													processPriceRanges(sportEvent, priceRangesNode);
												}
												if (venuesNode != null) {
													processVenues(sportEvent, venuesNode);
												}
												EventsData.getInstance().getEvents().add(sportEvent);
												break;
											}
											case "Miscellaneous":
											{
												MiscellaneousEvent miscellaneousEvent = new MiscellaneousEvent(eventId, eventName, eventInfo, eventFamily, genre);
												if (dates != null)
												{
													miscellaneousEvent.setDates(dates);
												}
												if (priceRangesNode != null) {
													processPriceRanges(miscellaneousEvent, priceRangesNode);
												}
												if (venuesNode != null) {
													processVenues(miscellaneousEvent, venuesNode);
												}
												EventsData.getInstance().getEvents().add(miscellaneousEvent);
												break;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (IOException ex) {
			LOG.error(ex.getMessage());
			throw new GenericException("Errore nel caricamento della pagina!");
		}

	}

	/**
	 * <p>
	 * Funzione di elaborazione delle fasce di prezzo di un evento
	 * <p>
	 */	
	private void processPriceRanges(Event event, JsonNode priceRangesNode) throws GenericException {
		
		// Leggo il primo valore dell'array del nodo PriceRange
		if (priceRangesNode.isArray()) {
			JsonNode priceRangeNode = priceRangesNode.get(0);
			PriceRange priceRange = new PriceRange();
			
			priceRange.setMin(priceRangeNode.get("min").floatValue());
			priceRange.setMax(priceRangeNode.get("max").floatValue());
			
			event.setPriceRange(priceRange);
		}								
	}

	/**
	 * <p>
	 * Funzione di elaborazione delle località di un evento
	 * <p>
	 */
	private void processVenues(Event event, JsonNode venuesNode) throws GenericException {
		
		// Leggo il primo valore dell'array del nodo venue
		if (venuesNode.isArray()) {
			JsonNode venueNode = venuesNode.get(0);
			Venue venue = new Venue();
			
			venue.setCityName(venueNode.get("city").get("name").asText());
			if (venueNode.hasNonNull("state")) {
				venue.setStateName(venueNode.get("state").get("name").asText());
				if (venueNode.get("state").hasNonNull("stateCode")) {
					venue.setStateCode(venueNode.get("state").get("stateCode").asText());
				}
			}
			
			event.setVenue(venue);
		}
	}

}