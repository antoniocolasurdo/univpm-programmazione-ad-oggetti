package it.univpm.progetto.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import it.univpm.progetto.exception.CustomException;
import it.univpm.progetto.model.Event;

@org.springframework.stereotype.Service
public interface Service {

	/**
	 * Metodo di recupero dei dati da Ticket Master
	 *
	 * @throws CustomException 
	 */
	public void readData() throws CustomException;

	/**
	 * Metodo di recupero dei metadati utilizzati nel modello dati del progetto
	 *
	 * @throws CustomException 
	 */
	public JsonNode getMetaData() throws CustomException;

	/**
	 * Metodo di recupero di tutti i dati recuperati da Ticket Master
	 *
	 * @throws CustomException 
	 */
	public List<Event> getData() throws CustomException;

}