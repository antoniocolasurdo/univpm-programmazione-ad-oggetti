package it.univpm.progetto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.univpm.progetto.data.EventsData;
import it.univpm.progetto.exception.GenericException;
import it.univpm.progetto.exception.WrongStartDateException;
import it.univpm.progetto.filter.FilterManager;
import it.univpm.progetto.service.Service;
import it.univpm.progetto.stats.Stats;

@SpringBootTest
class UnivpmProgrammazioneAdOggettiApplicationTests {

    /**
     * <p>
     * Costanti utilizzati nelle fasi di test
     * <p>
     */
	private final static int PAGES = 1;
	private final static int SIZE = 50;
	
    /**
     * <p>
     * Logger utilizzato per visualizzare e memorizzare i messaggi di sistema dell'applicazione e per intercettare i messaggi generati dalle eccezioni
     * <p>
     */
	private static final Logger LOG = LoggerFactory.getLogger(UnivpmProgrammazioneAdOggettiApplicationTests.class);

    /**
     * <p>
     * Servizio di caricamento e recupero dati e metadati
     * <p>
     */
	@Autowired
	private Service service;

    /**
     * <p>
     * Servizio di statistiche secondo i requisiti del progetto
     * <p>
     */
	@Autowired
	private Stats stats;

    /**
     * <p>
     * Inizializzazione dei test, vengono caricati un sottoinsieme di dati letti da Ticket Master
     * <p>
     */
	@PostConstruct
	void init() {

		try {
			service.readData(PAGES, SIZE);
			LOG.info("Dati caricati correttamente da Ticket Master");
		} catch (GenericException e) {
			LOG.error(e.getMessage());
		}

	}
	
    /**
     * <p>
     * Verifica se i dati letti da Ticket Master sono dello stesso numero richiesto
     * <p>
     */
	@Test
	@DisplayName("Verifica se i dati letti da Ticket Master sono dello stesso numero richiesto")
	void readDataTicketMaster() {

		try {
			assertEquals(EventsData.getInstance().getEvents().size(), PAGES * SIZE);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

	}

    /**
     * <p>
     * Verifica se sono recuperati gli eventi ai fini delle statistiche
     * <p>
     */
	@Test
	@DisplayName("Verifica se sono recuperati gli eventi ai fini delle statistiche")
	void getNumEventWithoutAnyFilter() {

		try {
			assertTrue(stats.getNumEvents(EventsData.getInstance().getEvents()).size() > 0);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

	}
	
    /**
     * <p>
     * Verifica eccezione sul filtro data iniziale
     * <p>
     */
	@Test
	@DisplayName("Verifica eccezione sul filtro data iniziale")
	void filterWithException() {

		try {
			WrongStartDateException ex = assertThrows(WrongStartDateException.class, () -> {
				FilterManager filterManager = new FilterManager(null, null, null, null, null, "01/01/2021", "31/12/2021");
				filterManager.validate();
			});
			
			assertEquals("Errore, la data inserita non è valida!", ex.getMessage());
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

	}

    /**
     * <p>
     * Verifica che il recupero degli stati non sia nullo
     * <p>
     */
	@Test
	@DisplayName("Verifica che il recupero degli stati non sia nullo")
	void getStatesNotIsNull() {

		try {
			assertTrue(stats.getStates(EventsData.getInstance().getEvents()) != null);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

	}

}