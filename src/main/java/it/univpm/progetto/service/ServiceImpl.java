package it.univpm.progetto.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import it.univpm.progetto.model.*;
import it.univpm.progetto.utils.FileUtils;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    /**
    * Logger utilizzato per visualizzare e memorizzare i messaggi di sistema dell'applicazione e per intercettare i messaggi generati dalle eccezioni
    */
	private static final Logger LOG = LoggerFactory.getLogger(ServiceImpl.class);

	Root events;
	
	public ServiceImpl() {

		ObjectMapper objectMapper = new ObjectMapper()
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.registerModule(new JodaModule());

		try {
			byte[] ticketMasterEventsJson = FileUtils.loadFile();
			
			events = objectMapper.readValue(ticketMasterEventsJson, Root.class);
		} catch (Exception ex) {
			LOG.error(ex.getMessage());
		}
		
	}
	
	@Override
	public String getData() {
		return "Prova";
	}

}
