package it.univpm.progetto.controller;

import java.util.HashMap;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.progetto.data.EventsData;
import it.univpm.progetto.stats.Stats;

@RestController
public class StatsController {

	@Autowired
	private Stats stats;

	@GetMapping("/stats/numEvents")
	public HashMap<String, Integer> getNumEvents() {
		return stats.getNumEvents(EventsData.getInstance().getEvents());
	}

	@GetMapping("/stats/numEventsGenre")
	public HashMap<String, int[]> getNumEventsGenre() {
		return stats.getNumEventsGenre(EventsData.getInstance().getEvents());
	}

	@GetMapping("/stats/getStates")
	public HashSet<String> getStates() {
		return stats.getStates(EventsData.getInstance().getEvents());
	}

}