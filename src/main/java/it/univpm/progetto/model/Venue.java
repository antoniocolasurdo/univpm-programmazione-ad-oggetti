package it.univpm.progetto.model;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe</b> che definisce le sedi dell'evento
 * </p>
 */
public class Venue {
	
	
	private String cityName;
	
	private String stateName;

	private String stateCode;

	/**
	 * <p>Ritorna il nome della città<p>
	 * 
	 * @return city
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * 
	 * @param cityName indica il nome della città
	 * 
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * <p>Ritorna il nome dello stato<p>
	 * 
	 * @return stateName
	 */
	public String getStateName() {
		return stateName;
	}
	/**
	 * 
	 * @param stateName indica il nome dello stato
	 * 
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	/**
	 * <p>Ritorna il codice dello stato<p>
	 * 
	 * @return stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}
	/**
	 * 
	 * @param stateCode indica il codice dello stato
	 * 
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

}