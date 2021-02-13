package it.univpm.progetto.exception;

/**
 * 
 */
public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8617215203403825398L;

	/**
	 * 
	 */
	private String message;
	
	/**
	 * 
	 */
	public CustomException(String message) {
		this.message = message;
	}
	
	/**
	 * 
	 */
	public String getMessage() {
		return message;
	}

}