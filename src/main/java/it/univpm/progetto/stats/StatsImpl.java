package it.univpm.progetto.stats;

import java.time.DayOfWeek;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;
import org.springframework.stereotype.Service;
import it.univpm.progetto.model.ArtsAndTheatreEvent;
import it.univpm.progetto.model.Event;
import it.univpm.progetto.model.MiscellaneousEvent;
import it.univpm.progetto.model.MusicEvent;
import it.univpm.progetto.model.SportEvent;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe</b> che implementa tutte le funzioni relative alle statistiche
 * </p>
 */
@Service
public class StatsImpl implements Stats {

	/**
	 * 
	 * <p>La HashMap è del tipo: {"stato1" : 10, "stato2" : 12, ecc..}</p>
	 * 
	 * @return numEvents
	 */
    @Override
    public HashMap<String, Integer> getNumEvents(Vector<Event> eventi) {


        HashMap<String, Integer> numEvents = new HashMap<String, Integer>();
        for (Event evento : eventi) {
            if (evento.getVenue() != null && evento.getVenue().getStateCode() != null) {

                int cont = 1;
                String code = evento.getVenue().getStateCode(); // codice dello stato
                if (numEvents.containsKey(code)) // Aggiorno il contatore
                    cont += numEvents.get(code);
                numEvents.put(code, cont);

            }
        }
        return numEvents;
    }

	/**
	 * 
	 * <p>La HashMap è del tipo: {"stato1" : (5,6,3,2), "stato2" : (12,4,11,5)}</p>
	 * <p>Il posizione dei numeri è la seguente: { "Sports", "Music", "Arts e Theatre", "Miscellaneous" }; (es: nello stato1 ci sono 5 eventi spotivi, 6 musicali, ecc...)</p>
	 * 
	 * @return numEventsGen
	 */
    @SuppressWarnings("serial")
	@Override
    public HashMap<String, HashMap<String, Integer>> getNumEventsGenre(Vector<Event> eventi) {
 
        // eventi raggruppati per stato e segment
        HashMap<String, HashMap<String, Integer>> numEventsGen = new HashMap<String, HashMap<String, Integer>>();
        for (String stato : this.getStates(eventi)) {
            numEventsGen.put(stato, new HashMap<String, Integer>() {{
            	put("Sport", 0);
            	put("Music", 0);
            	put("ArtsAndTheatre", 0);
            	put("Miscellaneous", 0);            	
            }}); // Inizializzazione valori HashMap
        }

        for (Event evento : eventi) {
            String code = evento.getVenue().getStateCode(); // codice dello stato
            if (code != null) {
                HashMap<String, Integer> map = numEventsGen.get(code); // Array contatore eventi per ogni genere
                // Incremento dei contatori in base al tipo di evento
                if (evento instanceof SportEvent) {
                	int sportCounter = map.get("Sport");
                	sportCounter++;
                	map.put("Sport", sportCounter);
                }
                else if (evento instanceof MusicEvent) {
                	int musicCounter = map.get("Music");
                	musicCounter++;
                	map.put("Music", musicCounter);
                }
                else if (evento instanceof ArtsAndTheatreEvent) {
                	int artsAndTheatreCounter = map.get("ArtsAndTheatre");
                	artsAndTheatreCounter++;
                	map.put("ArtsAndTheatre", artsAndTheatreCounter);
                }
                else if (evento instanceof MiscellaneousEvent) {
                	int miscellaneousCounter = map.get("Miscellaneous");
                	miscellaneousCounter++;
                	map.put("Miscellaneous", miscellaneousCounter);
                }
                else
                    continue;
                numEventsGen.put(code, map);
            }
        }
        return numEventsGen;
    }

	/**
	 * <p>Recupero stati</p>
	 * 
	 * @return statesCodes
	 */
    @Override
    public HashSet<String> getStates(Vector<Event> eventi) {
        HashSet<String> statesCodes = new HashSet<String>();
        for (Event evento : eventi) {
            if (evento.getVenue() != null && evento.getVenue().getStateCode() != null) {
                statesCodes.add(evento.getVenue().getStateCode());
            }
        }
        return statesCodes;
    }

	/**
	 * 
	 * <p>La HashMap è del tipo: {"stato1" : (5,6,3), "stato2" : (12,4,11)}</p>
	 * <p>Il posizione dei numeri segue quella di valore (min, max, medio)</p>
	 * <p>weekNum è l'unità espressa in settimane su cui basare il calcolo (weekNum = 4 indica una statistica mensile)</p>
	 * 
	 * @return numEvents
	 */
    @Override
    public HashMap<String, ValoriMinimoMassimoMedio> numEventsInterval(Vector<Event> eventi, int weekNum) {
  

        HashMap<String, ValoriMinimoMassimoMedio> numEvents = new HashMap<String, ValoriMinimoMassimoMedio>();


        // create WeekFields 
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 1);
        // apply weekOfYear() 
        TemporalField weekOfYear = weekFields.weekOfYear();

        // Ordina gli eventi in ordine cronologico
        eventi.sort((e1, e2) -> e1.getDates().getLocalDate().compareTo(e2.getDates().getLocalDate()));
        // get week of year for localdate 
        //int wow = day.get(weekOfYear);
        int startWeek = eventi.get(0).getDates().getLocalDate().get(weekOfYear); // numero settimana iniziale
        int endWeek = eventi.get(eventi.size() - 1).getDates().getLocalDate().get(weekOfYear); // numero settimana finale
        int n = ((endWeek - startWeek) / weekNum) + 1; // numero di settori temporali

        for (String stato : this.getStates(eventi)) {

            int[] valori = new int[n]; // numero degli eventi in ogni settore temporale

        	for (Event evento : eventi) {
                if (evento.getVenue() != null && evento.getVenue().getStateCode() != null && evento.getVenue().getStateCode().equals(stato)) {
                    // per ogni stato calcolo il valore min, max, medio
                    int eventWeek = evento.getDates().getLocalDate().get(weekOfYear); // numero settimana dell'evento
                    for (int i = 0; i < n; i++) {
                        if (eventWeek <= startWeek + weekNum * (i + 1)) { // incremento il settore temporale i-esimo
                            valori[i]++;
                            break;
                        }
                    }
                }
            }

        	ValoriMinimoMassimoMedio valoriCalcolati = new ValoriMinimoMassimoMedio(valori[0], valori[0], 0);
            // Calcolo valore min, max e medio basandomi sul vettore valori

            // Minimo e massimo
            float sum = 0;
            for (Integer valore : valori) {
                sum += valore;
                if (valore < valoriCalcolati.getMinimo()) // nuovo minimo
                	valoriCalcolati.setMinimo(valore);
                else if (valore > valoriCalcolati.getMassimo()) // nuovo massimo
                    valoriCalcolati.setMassimo(valore);
            }
            // Media
            valoriCalcolati.setMedia(sum / valori.length);

            // Aggiorna la HashMap
            numEvents.put(stato, valoriCalcolati);
        }

        return numEvents;
    }

}