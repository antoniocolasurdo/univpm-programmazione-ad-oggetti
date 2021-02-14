package it.univpm.progetto.stats;

import java.util.Vector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.univpm.progetto.model.Event;

public class StatsImpl implements Stats {

    // TODO Lista di liste per segmenti-generi

    @Override
    public int getNumEvents(Vector<Event> eventi) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ObjectNode getNumEventsGenre(Vector<Event> eventi) {
        ObjectMapper mapper = new ObjectMapper();

        ObjectNode root = mapper.createObjectNode();

    }

}
