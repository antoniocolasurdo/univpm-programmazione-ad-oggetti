package it.univpm.progetto.model;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * Classe che definisce l'id e il nome
 */
public class Venue {
	
	/**
	 * Definisce il nome della città
	 */
	private String cityName;
	/**
	 * Definisce il nome dello stato
	 */
	private String stateName;
	/**
	 * Definisce il codice dello stato
	 */
	private String stateCode;

	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

}