package it.univpm.progetto.stats;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe</b> che definisce i valori di minimo, massimo e medio
 * </p>
 */
public class ValoriMinimoMassimoMedio {

	private int minimo;
	private int massimo;
	private float media;
	
    /**
     * <p>Costruttore della classe, vengono inizializzati tutti i valori a 0</p>
     */
	public ValoriMinimoMassimoMedio() {
		this.minimo = 0;
		this.massimo = 0;
		this.media = 0;
	}

    /**
     * <p>Costruttore della classe</p>
     * 
     * @param minimo valore minimo
     * @param massimo valore massimo
     * @param media valore media
     */
	public ValoriMinimoMassimoMedio(int minimo, int massimo, float media) {
		this.minimo = minimo;
		this.massimo = massimo;
		this.media = media;
	}

    /**
     * <p>Ritorna il valore minimo</p>
     * 
     * @return minimo
     */
	public int getMinimo() {
		return minimo;
	}

    /**
     * 
     * @param minimo indica il valore minimo di eventi
     * 
     */
	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

    /**
     * <p>Ritorna il valore massimo<p>
     * 
     * @return massimo
     */
	public int getMassimo() {
		return massimo;
	}

    /**
     * 
     * @param massimo indica il valore massimo di eventi
     * 
     */
	public void setMassimo(int massimo) {
		this.massimo = massimo;
	}

    /**
     * <p>Ritorna il valore medio<p>
     * 
     * @return media
     */
	public float getMedia() {
		return media;
	}

    /**
     * 
     * @param media indica il valore medio di eventi
     * 
     */
	public void setMedia(float media) {
		this.media = media;
	}

}