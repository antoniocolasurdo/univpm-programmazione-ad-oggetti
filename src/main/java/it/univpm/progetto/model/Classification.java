package it.univpm.progetto.model;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe</b> che definisce la classificazione dell'evento
 * <p>
 */
public class Classification {
	

	private Segment segment;

	private Genre genre;

	private SubGenre subGenre;

	/**
	 * <p>
	 * Costruttore dell'oggetto classification
	 * <p>
	 */
	public Classification() {
		segment = new Segment();
		genre = new Genre();
		subGenre = new SubGenre();
	}
	
	/**
	 * <p>
	 * Ritorna il segmento di classificazione
	 * @return segment
	 * <p>
	 */
	public Segment getSegment() {
		return segment;
	}
	/**
	 * 
	 * @param segment indica il segmento di classificazione
	 * 
	 */
	public void setSegment(Segment segment) {
		this.segment = segment;
	}
	/**
	 * <p>
	 * Ritorna il genere dell'evento
	 * @return genre
	 * <p>
	 */
	public Genre getGenre() {
		return genre;
	}
	/**
	 * 
	 * @param genre indica il genere dell'evento
	 * 
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	/**
	 * <p>
	 * Ritorna il sottogenere dell'evento
	 * @return subGenre
	 * <p>
	 */
	public SubGenre getSubGenre() {
		return subGenre;
	}
	/**
	 * 
	 * @param subGenre indica il sottogenere dell'evento
	 * 
	 */
	public void setSubGenre(SubGenre subGenre) {
		this.subGenre = subGenre;
	}

}