package it.univpm.progetto.model;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe</b> che definisce gli eventi sul ghiaccio
 * </p>
 */
public class MiscellaneousEvent extends Event {

    private String miscellaneousGenre;

    public MiscellaneousEvent(String id, String name, String info, boolean family, String miscellaneousGenre) {
        super(id, name, info, family);
        this.miscellaneousGenre = miscellaneousGenre;
    }

	/**
	 * 
	 * @param miscellaneousGenre indica il genere dell'evento sul ghiaccio
	 * 
	 */
    public void setMiscellaneousGenre(String miscellaneousGenre) {
        this.miscellaneousGenre = miscellaneousGenre;
    }

	/**
	 * <p>Ritorna il genere dell'evento sul ghiaccio<p>
	 * 
	 * @return miscellaneousGenre
	 */
    @Override
    public String getGenre() {
        return miscellaneousGenre;
    }

}