package it.univpm.progetto.model;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe</b> che definisce la fascia di prezzo
 * <p>
 */
public class PriceRange {
	
 
    private float min;
 
    private float max;

    /**
     * <p>
     * Ritorna il prezzo minimo
     * @return min
     * <p>
     */
	public float getMin() {
		return min;
	}
	/**
	 * 
	 * @param min indica il prezzo minimo
	 * 
	 */
	public void setMin(float min) {
		this.min = min;
	}
	   /**
     * <p>
     * Ritorna il prezzo massimo
     * @return max
     * <p>
     */
	public float getMax() {
		return max;
	}
	/**
	 * 
	 * @param max indica il prezzo massimo
	 * 
	 */
	public void setMax(float max) {
		this.max = max;
	}

}