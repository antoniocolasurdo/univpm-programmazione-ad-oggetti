package it.univpm.progetto.model;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * Classe che definisce la classificazione dell'evento
 */
public class Classification {
	
	/**
	 * Definisce se è un evento principale
	 */
	private boolean primary;
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
	/**
	 * Definisce il tipo di evento
	 */
	private Type type;
	/**
	 * Definisce il sottotipo di evento
	 */
	private SubType subType;
	/**
	 * Definisce se l'evento è per famiglie
	 */
	private boolean family;

	public boolean isPrimary() {
		return primary;
	}
	public void setPrimary(boolean primary) {
		this.primary = primary;
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
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public SubType getSubType() {
		return subType;
	}
	public void setSubType(SubType subType) {
		this.subType = subType;
	}
	public boolean isFamily() {
		return family;
	}
	public void setFamily(boolean family) {
		this.family = family;
	}

}