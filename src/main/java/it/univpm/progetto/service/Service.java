package it.univpm.progetto.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import it.univpm.progetto.exception.GenericException;
import it.univpm.progetto.model.Event;

@org.springframework.stereotype.Service
public interface Service {

	/**
	 * Metodo di recupero dei dati da Ticket Master
	 *
	 * @throws GenericException 
	 */
	public void readData() throws GenericException;

	/**
	 * Metodo di recupero dei metadati utilizzati nel modello dati del progetto
	 *
	 * @throws GenericException 
	 */
	public JsonNode getMetaData() throws GenericException;

	/**
	 * Metodo di recupero di tutti i dati recuperati da Ticket Master
	 *
	 * @throws GenericException 
	 */
	public List<Event> getData() throws GenericException;

}