package it.univpm.progetto.model;

public class MusicEvent extends Event {

	private String musicGenre;
	private String musicSubGenre;

	public MusicEvent(String id, String name, String info, boolean family, String musicGenre, String musicSubGenre) {
		super(id, name, info, family);
		this.musicGenre = musicGenre;
		this.musicSubGenre = musicSubGenre;
	}
	
	public String getMusicGenre() {
		return musicGenre;
	}
	public void setMusicGenre(String musicGenre) {
		this.musicGenre = musicGenre;
	}
	public String getMusicSubGenre() {
		return musicSubGenre;
	}
	public void setMusicSubGenre(String musicSubGenre) {
		this.musicSubGenre = musicSubGenre;
	}
	
}