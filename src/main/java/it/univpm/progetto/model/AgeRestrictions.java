package it.univpm.progetto.model;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * Classe che definisce i limiti di età
 */
public class AgeRestrictions {
	
	/**
	 * Definisce se sono applicati i limiti di età
	 */
	private boolean legalAgeEnforced;

	public boolean isLegalAgeEnforced() {
		return legalAgeEnforced;
	}

	public void setLegalAgeEnforced(boolean legalAgeEnforced) {
		this.legalAgeEnforced = legalAgeEnforced;
	}

}