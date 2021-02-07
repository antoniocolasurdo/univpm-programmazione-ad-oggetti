package it.univpm.progetto.service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
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

import it.univpm.progetto.model.*;
/*
 * 
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

    /**
     * <p>
     * Lista degli eventi recuperati da Ticket Master
     * <p>
     */ 
    List<Event> events;
	
	public ServiceImpl() {

		// Oggetto di gestione del formato JSON della libreria jackson
		objectMapper = new ObjectMapper();

		// Lista degli eventi caricati da Ticket Master
		events = new ArrayList<Event>();
		
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
    * funzione di lettura dati per leggere i dati di TicketMaster di un numero <i>PAGES</i> di pagine
    * <p>
    */
	@Override
	public void readData() {
		
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
	public JsonNode getMetaData() {

		return processClass(Event.class);

	}

	private ObjectNode processClass(Class<?> classe) {

		// Creo il nodo all'interno del quale inserisco i campi della classe
		ObjectNode objectNode = objectMapper.createObjectNode();
		
		// Ciclo sulle proprietà della classe
		Field[] fields = classe.getDeclaredFields();
		for (Field field : fields) {
			
			// Se la proprietà è una List<?> recupero il tipo di dato
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
				if (field.getType().getSimpleName().equals("Dates") || field.getType().getSimpleName().equals("Segment") || 
						field.getType().getSimpleName().equals("Genre") || field.getType().getSimpleName().equals("SubGenre")) {
					
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
	public List<Event> getData() {
		return events;
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
	private void processPage(String ticketMasterData) {
		
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
							Event event = new Event(
									eventNode.get("name").asText(),
									eventNode.get("id").asText(),
									eventNode.hasNonNull("info") ? eventNode.get("info").asText() : null
									);
							
							// Elaborazione del sottoramo dates contenente le date dell'evento
							if (eventNode.has("dates")) {
								JsonNode datesNode = eventNode.get("dates");
								if (datesNode.has("start")) {
									JsonNode startNode = datesNode.get("start");
									if (startNode.hasNonNull("localDate")) {
										event.getDates().setLocalDate(LocalDate.parse(startNode.get("localDate").asText()));
									}
									if (startNode.hasNonNull("localTime")) {
										event.getDates().setLocalTime(LocalTime.parse(startNode.get("localTime").asText()));
									}
									if (startNode.hasNonNull("dateTime")) {
										event.getDates().setDateTime(DateTime.parse(startNode.get("dateTime").asText()));
									}
								}
							}

							// Elaborazione del sottoramo classifications
							if (eventNode.has("classifications")) {
								JsonNode classificationsNode = eventNode.get("classifications");
								for (JsonNode classificationNode : classificationsNode) {
									Classification classification = new Classification();
									
									if (classificationNode.has("segment")) {
									    classification.getSegment().setId(classificationNode.get("segment").get("id").asText());
									    classification.getSegment().setName(classificationNode.get("segment").get("name").asText());
									}
									if (classificationNode.has("genre")) {
									    classification.getSegment().setId(classificationNode.get("genre").get("id").asText());
									    classification.getSegment().setName(classificationNode.get("genre").get("name").asText());
									}
									if (classificationNode.has("subGenre")) {
									    classification.getSegment().setId(classificationNode.get("subGenre").get("id").asText());
									    classification.getSegment().setName(classificationNode.get("subGenre").get("name").asText());
									}
									
									event.getClassifications().add(classification);
								}
							}

							// Elaborazione del sottoramo priceRanges
							if (eventNode.has("priceRanges")) {
								JsonNode priceRangesNode = eventNode.get("priceRanges");
								for (JsonNode priceRangeNode : priceRangesNode) {
									PriceRange priceRange = new PriceRange();
									
									priceRange.setMin(priceRangeNode.get("min").floatValue());
									priceRange.setMax(priceRangeNode.get("max").floatValue());
									
									event.getPriceRanges().add(priceRange);
								}								
							}

							// Nel ramo _emdebbed vi sono gli altri oggetti dichiarati nel data model di Ticket Master
							if (eventNode.has("_embedded")) {
								JsonNode embeddedEventNode = eventNode.get("_embedded");
								
								// Elaborazione del sottonodo venues contenente un'array di località in cui si svolge l'evento
								if (embeddedEventNode.has("venues")) {
									JsonNode venuesNode = embeddedEventNode.get("venues");
									
									for (JsonNode venueNode : venuesNode) {
										Venue venue = new Venue();
										
										venue.setCityName(venueNode.get("city").get("name").asText());
										if (venueNode.hasNonNull("state")) {
											venue.setStateName(venueNode.get("state").get("name").asText());
											venue.setStateCode(venueNode.get("state").get("stateCode").asText());
										}
										
										event.getVenues().add(venue);
									}
								}
							}
							
							// Aggiunta dell'evento elaborato alla lista degli eventi
							events.add(event);
						}
					}
				}
			}
		} catch (IOException ex) {
			LOG.error(ex.getMessage());
		}

	}

}