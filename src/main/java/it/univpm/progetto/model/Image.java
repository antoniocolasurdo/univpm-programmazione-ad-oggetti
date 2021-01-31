package it.univpm.progetto.model;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * Classe che definisce le immagini dell'evento
 */
public class Image {
	
	/**
	 * Definisce il rapporto
	 */
	private String ratio;
	/**
	 * Definisce l'URL
	 */
	private String url;
	/**
	 * Definisce la larghezza
	 */
	private int width;
	/**
	 * Definisce l'altezza
	 */
	private int height;
	/**
	 * Definisce l'immagine di ripiego
	 */
	private boolean fallback;

	public String getRatio() {
		return ratio;
	}
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public boolean isFallback() {
		return fallback;
	}
	public void setFallback(boolean fallback) {
		this.fallback = fallback;
	}
}