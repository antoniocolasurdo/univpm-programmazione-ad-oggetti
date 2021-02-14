package it.univpm.progetto.model;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe</b> che definisce gli eventi musica
 * <p>
 */
public class MusicEvent extends Event {

	private String musicGenre;
	private String musicSubGenre;

	public MusicEvent(String id, String name, String info, boolean family, String musicGenre, String musicSubGenre) {
		super(id, name, info, family);
		this.musicGenre = musicGenre;
		this.musicSubGenre = musicSubGenre;
	}
	
	/**
	 * <p>
	 * Ritorna il genere dell'evento di musica
	 * @return musicGenre
	 * <p>
	 */
	public String getMusicGenre() {
		return musicGenre;
	}
	/**
	 * 
	 * @param musicGenre indica il genere dell'evento di musica
	 * 
	 */
	public void setMusicGenre(String musicGenre) {
		this.musicGenre = musicGenre;
	}
	/**
	 * <p>
	 * Ritorna il sottogenere dell'evento di musica
	 * @return musicSubGenre
	 * <p>
	 */
	public String getMusicSubGenre() {
		return musicSubGenre;
	}
	/**
	 * 
	 * @param musicSubGenre indica il sottogenere dell'evento di musica
	 * 
	 */
	public void setMusicSubGenre(String musicSubGenre) {
		this.musicSubGenre = musicSubGenre;
	}
	
}