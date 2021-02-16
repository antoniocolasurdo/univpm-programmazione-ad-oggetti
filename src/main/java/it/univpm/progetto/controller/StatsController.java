package it.univpm.progetto.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
import it.univpm.progetto.model.*;
import it.univpm.progetto.stats.Stats;

@RestController
public class StatsController {

	@Autowired
	private Stats stats;

	/**
	 * <p>
	 * Rotta che permette di recuperare il numero di eventi di ogni stato
	 * <p>
	 * @throws WrongPriceMaxException 
	 * @throws WrongNegativePriceMinException 
	 * @throws WrongStateException 
	 * @throws WrongSegmentException 
	 * @throws WrongGenreException 
	 * @throws WrongStartDateException 
	 * @throws WrongEndDateException 
	 * @throws WrongFormatDateException 
	 */
	@PostMapping("/stats/numEvents")
	public HashMap<String, Integer> getNumEvents(@RequestBody FilterManager filterManager) throws WrongFormatDateException, WrongEndDateException, WrongStartDateException, WrongGenreException, WrongSegmentException, WrongStateException, WrongNegativePriceMinException, WrongPriceMaxException {
		filterManager.validate();
		Vector<Event> filteredEvents = filterManager.filter(EventsData.getInstance().getEvents());
		
		return stats.getNumEvents(filteredEvents);
	}

	/**
	 * <p>
	 * Rotta che permette di recuperare il numero di eventi per genere
	 * <p>
	 * @throws WrongPriceMaxException 
	 * @throws WrongNegativePriceMinException 
	 * @throws WrongStateException 
	 * @throws WrongSegmentException 
	 * @throws WrongGenreException 
	 * @throws WrongStartDateException 
	 * @throws WrongEndDateException 
	 * @throws WrongFormatDateException 
	 */
	@PostMapping("/stats/numEventsGenre")
	public HashMap<String, int[]> getNumEventsGenre(@RequestBody FilterManager filterManager) throws WrongFormatDateException, WrongEndDateException, WrongStartDateException, WrongGenreException, WrongSegmentException, WrongStateException, WrongNegativePriceMinException, WrongPriceMaxException {
		filterManager.validate();
		Vector<Event> filteredEvents = filterManager.filter(EventsData.getInstance().getEvents());

		return stats.getNumEventsGenre(filteredEvents);
	}

	/**
	 * <p>
	 * Rotta che permette di recuperare l'insieme degli StateCode di tutti gli eventi
	 * <p>
	 * @throws WrongPriceMaxException 
	 * @throws WrongNegativePriceMinException 
	 * @throws WrongStateException 
	 * @throws WrongSegmentException 
	 * @throws WrongGenreException 
	 * @throws WrongStartDateException 
	 * @throws WrongEndDateException 
	 * @throws WrongFormatDateException 
	 */
	@PostMapping("/stats/getStates")
	public HashSet<String> getStates(@RequestBody FilterManager filterManager) throws WrongFormatDateException, WrongEndDateException, WrongStartDateException, WrongGenreException, WrongSegmentException, WrongStateException, WrongNegativePriceMinException, WrongPriceMaxException {
		filterManager.validate();
		Vector<Event> filteredEvents = filterManager.filter(EventsData.getInstance().getEvents());

		return stats.getStates(filteredEvents);
	}

}