package it.univpm.progetto.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import it.univpm.progetto.exception.GenericException;
import it.univpm.progetto.model.Event;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Interfaccia</b> delle funzioni di servizio
 * </p>
 */
@org.springframework.stereotype.Service
public interface Service {

	/**
	 * Metodo di recupero dei dati da Ticket Master utilizzando i parametri di configurazione del file <b>config.json</b>
	 *
	 * @throws GenericException eccezione generica
	 */
	public void readData() throws GenericException;

	/**
	 * Metodo di recupero dei dati da Ticket Master utilizzando numero di pagine e grandezza specifici
	 * 
	 * @param pages indica il numero di pagine dati da leggere su TicketMaster
	 * @param size indica il numero di elementi di una pagina
	 *
	 * @throws GenericException eccezione generica
	 */
	public void readData(int pages, int size) throws GenericException;

	/**
	 * Metodo di recupero dei metadati utilizzati nel modello dati del progetto
	 *
	 * @throws GenericException eccezione generica
	 * 
	 * @return oggetto JSON contenente i metadati
	 */
	public JsonNode getMetaData() throws GenericException;

	/**
	 * Metodo di recupero di tutti i dati recuperati da Ticket Master
	 *
	 * @throws GenericException eccezione generica
	 * 
	 * @return lista degli eventi recuperati
	 */
	public List<Event> getData() throws GenericException;

}