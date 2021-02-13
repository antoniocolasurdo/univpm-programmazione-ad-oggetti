package it.univpm.progetto.model;

public class MiscellaneousEvent extends Event {

	private String miscellaneousGenre;

	public MiscellaneousEvent(String id, String name, String info, boolean family, String miscellaneousGenre) {
		super(id, name, info, family);
		this.miscellaneousGenre = miscellaneousGenre;
	}
	
	public String getMiscellaneousGenre() {
		return miscellaneousGenre;
	}

	public void setMiscellaneousGenre(String miscellaneousGenre) {
		this.miscellaneousGenre = miscellaneousGenre;
	}

}