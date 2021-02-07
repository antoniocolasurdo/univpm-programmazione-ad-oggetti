package it.univpm.progetto.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import it.univpm.progetto.model.Event;

@org.springframework.stereotype.Service
public interface Service {

	/**
	 * Metodo di recupero dei dati da Ticket Master
	 */
	public void readData();

	/**
	 * Metodo di recupero dei metadati utilizzati nel modello dati del progetto
	 */
	public JsonNode getMetaData();

	/**
	 * Metodo di recupero di tutti i dati recuperati da Ticket Master
	 */
	public List<Event> getData();

}