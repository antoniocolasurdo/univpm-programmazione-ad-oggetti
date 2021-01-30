package it.univpm.progetto.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import it.univpm.progetto.utils.Costanti;
import it.univpm.progetto.utils.FileUtils;


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
    * Oggetto RestTemplate utilizzato per accedere all'API Get messa a disposizione da Ticket Master
    */
    @Autowired
    private RestTemplate restTemplate;
    
    /**
    * Metodo di esecuzione lanciato alla partenza dell'applicazione Spring Boot
    */
    @Override
    public void run(String...args) throws Exception {
    	if (!FileUtils.fileExist()) {
    		LOG.info("Caricamento dati da Ticket Master ...");
        	ResponseEntity<String> response = restTemplate.getForEntity(getTicketMasterUrl(), String.class);

        	if (response.getStatusCode() == HttpStatus.OK) {
        		String ticketMasterJson = response.getBody();
        		FileUtils.saveFile(ticketMasterJson.getBytes());
        		LOG.info("Caricamento dati da Ticket Master avvenuto correttamente!");
        	}
        	else {
        		LOG.error("Errore nel recupero dei dati da Ticket Master, statusCode: " + response.getStatusCodeValue());
        	}
    	}
    	else {
    		LOG.info("File JSON già presente!");
    	}
    }
    
    /**
    * Funzione di recupero della URL per accedere a Ticker Master
    */
    private String getTicketMasterUrl() {
    	String result = "";
    	
    	result += Costanti.TICKET_MASTER_URL;
    	result += "?countryCode=" + Costanti.COUNTRY_FILTER;
    	result += "&apikey=" + Costanti.API_KEY;
    	
    	return result;
    }
}