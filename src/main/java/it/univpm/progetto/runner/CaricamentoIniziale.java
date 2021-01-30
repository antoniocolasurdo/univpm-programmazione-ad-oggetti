package it.univpm.progetto.runner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * Classe di caricamento iniziale dei dati da TicketMaster secondo le specifiche di progetto
 */
@Component
public class CaricamentoIniziale implements CommandLineRunner {

    /**
    * Logger utilizzato per visualizzare e memorizzare i messaggi di sistema dell'applicazione e per intercettare i messaggi generati dalle eccezioni
    */
	private static final Logger LOG = LoggerFactory.getLogger(CaricamentoIniziale.class);

    /**
    * Definizione dei parametri di accesso agli eventi del sito Ticket Master richiesto nel progetto
    */
    private final static String TICKET_MASTER_URL = "https://app.ticketmaster.com/discovery/v2/events.json";
    private final static String COUNTRY_FILTER = "US";
    private final static String API_KEY = "pgAP0yglhrdbzvXSQem3WrDfGpwywPaw";

    /**
    * Definizione della cartella e del nome file sul quale vengono scritti gli eventi recuperati da Ticker Master
    */
    private final static String RESOURCE_PATH = "src/main/resources";
    private final static String RESOURCE_FILENAME = "/ticket_master_events.json";
    
    /**
    * Oggetto RestTemplate utilizzato per accedere all'API Get messa a disposizione da Ticket Master
    */
    @Autowired
    private RestTemplate restTemplate;
    
    /**
    * Metodo di esecuzione lanciato alla partenza dell'applicazione Spring Boot
    */
    @Override
    public void run(String...args) throws Exception {
    	if (!fileExist()) {
        	ResponseEntity<String> response = restTemplate.getForEntity(getTicketMasterUrl(), String.class);

        	if (response.getStatusCode() == HttpStatus.OK) {
        		String ticketMasterJson = response.getBody();
        		saveFile(ticketMasterJson.getBytes());
        	}
    	}
    }
    
    /**
    * Funzione di recupero della URL per accedere a Ticker Master
    */
    private String getTicketMasterUrl() {
    	String result = "";
    	
    	result += TICKET_MASTER_URL;
    	result += "?countryCode=" + COUNTRY_FILTER;
    	result += "&apikey=" + API_KEY;
    	
    	return result;
    }

    /**
    * Funzione di verifica se il file contenente gli eventi di Ticket Master esiste o meno
    */
    private boolean fileExist() {
    	File file = new File(RESOURCE_PATH + RESOURCE_FILENAME);
    	
    	return file.exists();
    }
    
    /**
    * Funzione di salvataggio del file all'interno della struttura del progetto
    */
	private String saveFile(byte[] bytes) throws MalformedURLException, IOException {
		File file = new File(RESOURCE_PATH + RESOURCE_FILENAME);
		    
		OutputStream out = new FileOutputStream(file);
		try {
		    out.write(bytes);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		} finally {
		    out.close();
		}
		
		return file.getName();
	}
}