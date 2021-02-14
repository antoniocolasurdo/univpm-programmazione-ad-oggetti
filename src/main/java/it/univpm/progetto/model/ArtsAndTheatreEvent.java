package it.univpm.progetto.model;

public class ArtsAndTheatreEvent extends Event {

    private String artsAndTheatreGenre;
    private String artsAndTheatreSubGenre;

    public ArtsAndTheatreEvent(String id, String name, String info, boolean family, String artsAndTheatreGenre,
            String artsAndTheatreSubGenre) {
        super(id, name, info, family);
        this.artsAndTheatreGenre = artsAndTheatreGenre;
        this.artsAndTheatreSubGenre = artsAndTheatreSubGenre;
    }

    public void setArtsAndTheatreGenre(String artsAndTheatreGenre) {
        this.artsAndTheatreGenre = artsAndTheatreGenre;
    }

    public String getArtsAndTheatreSubGenre() {
        return artsAndTheatreSubGenre;
    }

    public void setArtsAndTheatreSubGenre(String artsAndTheatreSubGenre) {
        this.artsAndTheatreSubGenre = artsAndTheatreSubGenre;
    }

    @Override
    public String getGenre() {
        return artsAndTheatreGenre;
    }

}