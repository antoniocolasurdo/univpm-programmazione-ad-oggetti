package it.univpm.progetto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import it.univpm.progetto.model.Event;
import it.univpm.progetto.service.Service;

@RestController
public class Controller {
	
	@Autowired
	private Service service;

	/**
	 * Rotta che permette di leggere i dati da TicketMaster e crea la struttura degli eventi con attribbuti e proprietà richieste dalle specifiche di progetto
	 */
	
	@PostMapping("/readData")
	public void readData() {
		service.readData();
	}

	@GetMapping("/getMetaData")
	public JsonNode getMetaData() {
		return service.getMetaData();
	}


	@GetMapping("/getData")
	public List<Event> getData() {
		return service.getData();
	}

}