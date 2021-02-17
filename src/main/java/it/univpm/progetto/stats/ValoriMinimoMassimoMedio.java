package it.univpm.progetto.stats;

public class ValoriMinimoMassimoMedio {

	private int minimo;
	private int massimo;
	private float media;
	
	public ValoriMinimoMassimoMedio() {
		this.minimo = 0;
		this.massimo = 0;
		this.media = 0;
	}

	public ValoriMinimoMassimoMedio(int minimo, int massimo, float media) {
		this.minimo = minimo;
		this.massimo = massimo;
		this.media = media;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public int getMassimo() {
		return massimo;
	}

	public void setMassimo(int massimo) {
		this.massimo = massimo;
	}

	public float getMedia() {
		return media;
	}

	public void setMedia(float media) {
		this.media = media;
	}

}