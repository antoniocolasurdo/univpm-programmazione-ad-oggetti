package it.univpm.progetto.service;

import java.io.File;
import java.io.IOException;
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
import it.univpm.progetto.model.*;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    /**
    * Logger utilizzato per visualizzare e memorizzare i messaggi di sistema dell'applicazione e per intercettare i messaggi generati dalle eccezioni
    */
	private static final Logger LOG = LoggerFactory.getLogger(ServiceImpl.class);

    /**
    * Oggetto utilizzato per deserializzare i dati ricevuti in formato JSON
    */
	ObjectMapper objectMapper;

    /**
    * Variabili contenenti la configurazione del progetto e che vengono valorizzate quando la classe viene istanziata
    */
    private static String TICKET_MASTER_URL;
    private static String TICKET_MASTER_FILTER;
    private static String TICKET_MASTER_API_KEY;
    private static int PAGES;
    private static int SIZE;
	
    /**
    * Oggetto RestTemplate utilizzato per accedere all'API Get messa a disposizione da Ticket Master
    */
    @Autowired
    private RestTemplate restTemplate;

    /**
    * Lista degli eventi recuperati da Ticket Master
    */
    List<Event> events;
	
	public ServiceImpl() {

		objectMapper = new ObjectMapper();

		events = new ArrayList<Event>();
		
		try {
			File configFile = new File("src/main/resources/config.json");
			JsonNode configNode = objectMapper.readTree(configFile);
			TICKET_MASTER_URL = configNode.get("TICKET_MASTER_URL").asText();
			TICKET_MASTER_FILTER = configNode.get("TICKET_MASTER_FILTER").asText();
			TICKET_MASTER_API_KEY = configNode.get("TICKET_MASTER_API_KEY").asText();
			PAGES = configNode.get("PAGES").asInt();
			SIZE = configNode.get("SIZE").asInt();

			//events = objectMapper.readValue(ticketMasterEventsJson, Root.class);
		} catch (Exception ex) {
			LOG.error(ex.getMessage());
		}
		
	}
	
	@Override
	public String getData() {
		return "Prova";
	}

	@Override
	public void readData() {
		
    	for (int index = 0; index < PAGES; index ++) {
    		
    		LOG.info("Caricamento dati da Ticket Master, pagina " + index);
        	ResponseEntity<String> response = restTemplate.getForEntity(getTicketMasterUrl(index), String.class);

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
	 * Funzione di costruzione della URL che accede a Ticket Master in base al numero di pagina
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
	 * Funzione di elaborazione dei dati della pagina inserendo i record recuperati nel modello dati
	 */
	private void processPage(String ticketMasterData) {
		
		try {
			JsonNode rootNode = objectMapper.readTree(ticketMasterData);

			if (rootNode.has("_embedded")) {
				JsonNode embeddedNode = rootNode.get("_embedded");
			
				if (embeddedNode.has("events")) {
					JsonNode eventsNode = embeddedNode.get("events");

					if (eventsNode.isArray()) {

						for (JsonNode eventNode : eventsNode) {
							Event event = new Event();
							event.setName(eventNode.get("name").asText());
							event.setId(eventNode.get("id").asText());
							if (eventNode.hasNonNull("info")) {
								event.setInfo(eventNode.get("info").asText());
							}

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

							if (eventNode.has("priceRanges")) {
								JsonNode priceRangesNode = eventNode.get("priceRanges");
								for (JsonNode priceRangeNode : priceRangesNode) {
									PriceRange priceRange = new PriceRange();
									
									priceRange.setMin(priceRangeNode.get("min").floatValue());
									priceRange.setMax(priceRangeNode.get("max").floatValue());
									
									event.getPriceRanges().add(priceRange);
								}								
							}

							if (eventNode.has("_embedded")) {
								JsonNode embeddedEventNode = eventNode.get("_embedded");
								
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