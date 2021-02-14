package it.univpm.progetto.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Antonio Colasurdo e Daniele Sergiacomi
 * 
 *         <p>
 *         <b>Classe</b> che definisce le date degli eventi
 *         <p>
 */
public class Dates {

    private LocalDate localDate;
    private LocalTime localTime;

    public Dates(LocalDate localDate, LocalTime localTime) {
        this.localDate = localDate;
        this.localTime = localTime;
    }

    /**
     * <p>
     * Ritorna la data locale dell'evento
     * 
     * @return LocalDate
     *         <p>
     */
    public LocalDate getLocalDate() {
        return localDate;
    }

    /**
     * 
     * @param localDate indica la data dell'evento
     * 
     */
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    /**
     * <p>
     * Ritorna l'orario locale dell'evento
     * 
     * @return LocalTime
     *         <p>
     */
    public LocalTime getLocalTime() {
        return localTime;
    }

    /**
     * 
     * @param LocalTime indica l'orario dell'evento
     * 
     */
    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

}