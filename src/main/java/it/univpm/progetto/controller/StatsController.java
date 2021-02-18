package it.univpm.progetto.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
import it.univpm.progetto.stats.ValoriMinimoMassimoMedio;

@RestController
public class StatsController {

	@Autowired
	private Stats stats;

	/**
	 * <p>Rotta che permette di recuperare il numero di eventi di ogni stato</p>
	 * 
	 * @param filterManager è il gestore dei filtri
	 *  
	 * @throws ResponseStatusException Response status exception
	 * 
	 * @return numEvents
	 */
	@PostMapping("/stats/numEvents")
	public HashMap<String, Integer> getNumEvents(@RequestBody(required = false) FilterManager filterManager) {
		try {
			// Se viene introdotto un filtro quindi filterManager non è nullo allora fa la validazione  
			if (filterManager != null) {
				filterManager.validate();
				Vector<Event> filteredEvents = filterManager.filter(EventsData.getInstance().getEvents());
				
				return stats.getNumEvents(filteredEvents);
			}
			
		} catch(WrongFormatDateException | WrongEndDateException | WrongStartDateException | WrongGenreException | WrongSegmentException | WrongStateException | WrongNegativePriceMinException | WrongPriceMaxException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);

		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}
		
		return stats.getNumEvents(EventsData.getInstance().getEvents());
	}

	/**
	 * <p>Rotta che permette di recuperare il numero di eventi per genere</p>
	 * @param filterManager è il gestore dei filtri
	 * 
	 * @throws ResponseStatusException Response status exception
	 * 
	 * @return numEventsGen
	 */
	@PostMapping("/stats/numEventsGenre")
	public HashMap<String, int[]> getNumEventsGenre(@RequestBody(required = false) FilterManager filterManager) {
		try {
			// Se viene introdotto un filtro quindi filterManager non è nullo allora fa la validazione 
			if (filterManager != null) {
				filterManager.validate();
				Vector<Event> filteredEvents = filterManager.filter(EventsData.getInstance().getEvents());
		
				return stats.getNumEventsGenre(filteredEvents);
			}

		} catch(WrongFormatDateException | WrongEndDateException | WrongStartDateException | WrongGenreException | WrongSegmentException | WrongStateException | WrongNegativePriceMinException | WrongPriceMaxException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
	
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}

		return stats.getNumEventsGenre(EventsData.getInstance().getEvents());
	}

	/**
	 * <p>Rotta che permette di recuperare l'insieme degli StateCode di tutti gli eventi</p>
	 * 
	 * @param filterManager è il gestore dei filtri
	 * 
	 * @throws ResponseStatusException Response status exception 
	 * 
	 * @return statesCodes
	 */
	@PostMapping("/stats/getStates")
	public HashSet<String> getStates(@RequestBody(required = false) FilterManager filterManager) {
		try {
			// Se viene introdotto un filtro quindi filterManager non è nullo allora fa la validazione 
			if (filterManager != null) {
				filterManager.validate();
				Vector<Event> filteredEvents = filterManager.filter(EventsData.getInstance().getEvents());

				return stats.getStates(filteredEvents);
			}

		} catch(WrongFormatDateException | WrongEndDateException | WrongStartDateException | WrongGenreException | WrongSegmentException | WrongStateException | WrongNegativePriceMinException | WrongPriceMaxException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
	
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}

		return stats.getStates(EventsData.getInstance().getEvents());
	}

	/**
	 * <p>Rotta che permette di recuperare l'insieme degli StateCode di tutti gli eventi</p>
	 *
	 * @param filterManager è il gestore dei filtri
	 * @param weekNum numero di settimane richieste, il valore di default è 4
	 * 
	 * @throws ResponseStatusException Response status exception
	 * 
	 * @return numEvents
	 */
	@Validated
	@PostMapping("/stats/numEventsInterval")
	public HashMap<String, ValoriMinimoMassimoMedio> numEventsInterval(@RequestBody(required = false) FilterManager filterManager, @RequestParam(name = "weekNum", required = false, defaultValue = "4") @Min(1) @Max(52) int weekNum) {
		try {
			// Se viene introdotto un filtro quindi filterManager non è nullo allora fa la validazione 
			if (filterManager != null) {
				filterManager.validate();
				Vector<Event> filteredEvents = filterManager.filter(EventsData.getInstance().getEvents());

				return stats.numEventsInterval(filteredEvents, weekNum);
			}

		} catch(WrongFormatDateException | WrongEndDateException | WrongStartDateException | WrongGenreException | WrongSegmentException | WrongStateException | WrongNegativePriceMinException | WrongPriceMaxException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
	
		} catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}

		return stats.numEventsInterval(EventsData.getInstance().getEvents(), weekNum);
	}

}