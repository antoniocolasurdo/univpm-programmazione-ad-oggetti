package it.univpm.progetto.model;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe</b> che definisce gli eventi sport
 * <p>
 */
public class SportEvent extends Event {

	private String sportGenre;

	public SportEvent(String id, String name, String info, boolean family, String sportGenre) {
		super(id, name, info, family);
		this.sportGenre = sportGenre;
	}
	
	/**
	 * <p>
	 * Ritorna il genere dell'evento sport
	 * @return sportGenre
	 * <p>
	 */
	public String getSportGenre() {
		return sportGenre;
	}
	/**
	 * 
	 * @param sportGenre indica il genere dell'evento sport
	 * 
	 */
	public void setSportGenre(String sportGenre) {
		this.sportGenre = sportGenre;
	}
	
}