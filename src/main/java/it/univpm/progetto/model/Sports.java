package it.univpm.progetto.model;


	/**
	 * @author Antonio Colasurdo e Daniele Sergiacomi
	 * 
	 * <p>
	 * <b>Classe</b> che definisce la categoria Musica di evento
	 * <p>
	 */

  public class Sports extends Event {
		
		private String SportsGenre;
		
		/**
		 * <p>
		 * Costruttore di default della classe Music
		 * <p>
		 */
		public Sports(String SportsGenre) {
			
			super();
			
			this.SportsGenre = new SportsGenre();
			
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
			
			this.SportsGenre = new SportsGenre();
			
			
		}
	    
		public String getSportsGenre() {
			
			return SportsGenre;
			
		}
		
	    
		public void setSportsGenre(String SportsGenre) {
			
			this.SportsGenre = SportsGenre;
			
		}
		
}
