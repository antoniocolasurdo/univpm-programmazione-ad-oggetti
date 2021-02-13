package it.univpm.progetto.model;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe</b> che definisce le sedi dell'evento
 * <p>
 */
public class UsaStates {
	
	
	private String city;
	
	private String stateName;

	private String stateCode;
	
	private String Address;

	/**
	 * <p>
	 * Ritorna il nome della città
	 * @return city
	 * <p>
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 
	 * @param city indica il nome della città
	 * 
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * <p>
	 * Ritorna il nome dello stato
	 * @return stateName
	 * <p>
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
	 * <p>
	 * Ritorna il codice dello stato
	 * @return stateCode
	 * <p>
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
	/**
	 * <p>
	 * Ritorna l'indirizzo dell'evento
	 * @return Address
	 * <p>
	 */
	public String getAddress() {
		return Address;
	}
	/**
	 * 
	 * @param Address indica l'indirizzo dell'evento
	 * 
	 */
	public void setAddress(String Address) {
		this.Address = Address;
	}

}