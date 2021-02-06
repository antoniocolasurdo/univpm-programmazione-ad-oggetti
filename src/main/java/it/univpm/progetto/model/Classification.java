package it.univpm.progetto.model;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * Classe che definisce la classificazione dell'evento
 */
public class Classification {
	
	/**
	 * Definisce il segmento di classificazione
	 */
	private Segment segment;
	/**
	 * Definisce il genere dell'evento
	 */
	private Genre genre;
	/**
	 * Definisce il sottogenere dell'evento
	 */
	private SubGenre subGenre;

	public Classification() {
		segment = new Segment();
		genre = new Genre();
		subGenre = new SubGenre();
	}
	
	public Segment getSegment() {
		return segment;
	}
	public void setSegment(Segment segment) {
		this.segment = segment;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public SubGenre getSubGenre() {
		return subGenre;
	}
	public void setSubGenre(SubGenre subGenre) {
		this.subGenre = subGenre;
	}

}