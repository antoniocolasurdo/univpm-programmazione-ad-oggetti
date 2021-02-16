package it.univpm.progetto.controller;

import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.progetto.data.EventsData;
import it.univpm.progetto.exception.WrongEndDateException;
import it.univpm.progetto.exception.WrongFormatDateException;
import it.univpm.progetto.exception.WrongGenreException;
import it.univpm.progetto.exception.WrongNegativePriceMinException;
import it.univpm.progetto.exception.WrongPriceMaxException;
import it.univpm.progetto.exception.WrongSegmentException;
import it.univpm.progetto.exception.WrongStartDateException;
import it.univpm.progetto.exception.WrongStateException;
import it.univpm.progetto.filter.FilterManager;

@RestController
public class FilterController {

	@GetMapping("/applyFilter")
	public HashMap<String, Integer> filterData(@RequestParam("segment") String segment, @RequestParam("genre") String genre,
			@RequestParam("state") String stateCode, @RequestParam("priceMin") Float priceMin,
			@RequestParam("priceMax") Float priceMax, @RequestParam("startDate") String from,
			@RequestParam("endDate") String to) throws WrongFormatDateException, WrongEndDateException, WrongStartDateException, WrongGenreException, WrongSegmentException, WrongStateException, WrongNegativePriceMinException, WrongPriceMaxException {
		
		FilterManager filterManager = new FilterManager(segment, genre, stateCode, priceMin, priceMax, from, to);
		
		filterManager.validate();
		filterManager.filter(EventsData.getInstance().getEvents());
		
		// probabilmente era intenzione di restituire la lista degli eventi che sono stati oggetto del filtro per poi ottenere le relative statistiche
		return null;
	}

}