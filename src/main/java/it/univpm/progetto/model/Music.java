package it.univpm.progetto.model;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe</b> che definisce la categoria Musica di evento
 * <p>
 */

public class Music extends Event {
	
	private String MusicGenre;
	
	private String MusicSubGenre;
	
	/**
	 * <p>
	 * Costruttore di default della classe Music
	 * <p>
	 */
	public Music(String MusicGenre, String MusicSubGenre) {
		
		super();
		
		this.MusicGenre = new MusicGenre();
		
		this.MusicSubGenre = new MusicSubGenre();
		
	}
	
    /**
     * Costruttore
     * 
     * @param name
     * @param info
     * @param family
     * @param dates
     * @param PriceRange
     * @param Location
     */
    public Music(String name, String info, boolean family, Dates dates, PriceRange PriceRange, UsaStates Location) {
      
    	super(name, info, family, dates, PriceRange, Location);
		
		this.MusicGenre = new MusicGenre();
		
		this.MusicSubGenre = new MusicSubGenre();
		
	}
    
	public String getMusicGenre() {
		
		return MusicGenre;
		
	}
	
	public String getMusicSubGenre() {
		
		return MusicSubGenre;
		
	}
    
	public void setMusicGenre(String MusicGenre) {
		
		this.MusicGenre = MusicGenre;
		
	}
	
	public void setMusicSubGenre(String MusicSubGenre) {
		
		this.MusicSubGenre = MusicSubGenre;
		
	}
}
    
    