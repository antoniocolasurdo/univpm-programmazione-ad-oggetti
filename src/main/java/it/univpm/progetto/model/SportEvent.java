package it.univpm.progetto.model;

public class SportEvent extends Event {

	private String sportGenre;

	public SportEvent(String id, String name, String info, boolean family, String sportGenre) {
		super(id, name, info, family);
		this.sportGenre = sportGenre;
	}
	
	public String getSportGenre() {
		return sportGenre;
	}
	public void setSportGenre(String sportGenre) {
		this.sportGenre = sportGenre;
	}
	
}