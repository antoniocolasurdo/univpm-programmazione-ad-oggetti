package it.univpm.progetto.model;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * Classe che definisce la fascia di prezzo
 */
public class PriceRange {
	
    /**
     * Definisce il prezzo minimo
     */
    private float min;
    /**
     * Definisce il prezzo massimo
     */
    private float max;

	public float getMin() {
		return min;
	}
	public void setMin(float min) {
		this.min = min;
	}
	public float getMax() {
		return max;
	}
	public void setMax(float max) {
		this.max = max;
	}

}