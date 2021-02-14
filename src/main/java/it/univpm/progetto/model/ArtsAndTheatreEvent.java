package it.univpm.progetto.model;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe</b> che definisce gli eventi di arte e teatro
 * <p>
 */
public class ArtsAndTheatreEvent extends Event {

    private String artsAndTheatreGenre;
    private String artsAndTheatreSubGenre;

    public ArtsAndTheatreEvent(String id, String name, String info, boolean family, String artsAndTheatreGenre,
            String artsAndTheatreSubGenre) {
        super(id, name, info, family);
        this.artsAndTheatreGenre = artsAndTheatreGenre;
        this.artsAndTheatreSubGenre = artsAndTheatreSubGenre;
    }

    /**
	 * <p>
	 * Ritorna il genere dell'evento arte e teatro
	 * @return artsAndTheatreGenre
	 * <p>
	 */
    @Override
    public String getGenre() {
        return artsAndTheatreGenre;
    }
	/**
	 * 
	 * @param artsAndTheatreGenre indica il genere dell'evento arte e teatro
	 * 
	 */
	public void setArtsAndTheatreGenre(String artsAndTheatreGenre) {
		this.artsAndTheatreGenre = artsAndTheatreGenre;
	}
	/**
	 * <p>
	 * Ritorna il sottogenere dell'evento arte e teatro
	 * @return artsAndTheatreSubGenre
	 * <p>
	 */
	public String getArtsAndTheatreSubGenre() {
		return artsAndTheatreSubGenre;
	}
	/**
	 * 
	 * @param artsAndTheatreSubGenre indica il sottogenere dell'evento arte e teatro
	 * 
	 */
	public void setArtsAndTheatreSubGenre(String artsAndTheatreSubGenre) {
		this.artsAndTheatreSubGenre = artsAndTheatreSubGenre;
	}

}