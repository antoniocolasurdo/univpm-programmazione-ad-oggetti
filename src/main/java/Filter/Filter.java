package Filter;
/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 * <p>
 * <b>Classe Astratta</b> dei filtri implementati
 * <p>
 */
public abstract class Filter {
	    /**
	     * Filtra le misure in ingresso
	     * 
	     * @param misure
	     */
	    public abstract void filtra();

	    /**
	     * Verifica che i parametri passati in ingresso al filtro siano validi o meno
	     */
	    public abstract void validate();
	}

