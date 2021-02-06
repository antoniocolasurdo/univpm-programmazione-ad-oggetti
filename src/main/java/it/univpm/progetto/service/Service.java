package it.univpm.progetto.service;

@org.springframework.stereotype.Service
public interface Service {

	/**
	 * Metodo di prova
	 * @return prova
	 */
	public String getData();

	/**
	 * Metodo di recupero dei dati da Ticket Master
	 */
	public void readData();
}