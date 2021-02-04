package it.univpm.progetto.model;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * Classe che definisce la vendita pubblica
 */
public class PublicSale extends StartEndDateTime {

	private boolean startTBD;
    private boolean startTBA;

    public boolean isStartTBD() {
		return startTBD;
	}
	public void setStartTBD(boolean startTBD) {
		this.startTBD = startTBD;
	}
	public boolean isStartTBA() {
		return startTBA;
	}
	public void setStartTBA(boolean startTBA) {
		this.startTBA = startTBA;
	}

}