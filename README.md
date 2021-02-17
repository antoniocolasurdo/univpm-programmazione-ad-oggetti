# Progetto_Programmazione_ad_Oggetti_di_Sergiacomi_Colasurdo

# Indice

- [Introduzione](#introduzione)


- [Diagrammi UML](#diagrammi-uml)


- [Rotte](#rotte)


- [Gestione Eccezioni](#gestione-eccezioni)


- [Test](#test)


- [Tecnologie utilizzate](#tecnologie-utilizzate)


- [Autori](#autori)


# Introduzione

Il programma permette di vedere tutti gli eventi degli USA recuperando i dati tramite una chiamata API da TicketMaster; l'utente può visualizzare l'id dell'evento, il nome dell'evento, la data, l'ora, il range di prezzo del biglietto, lo stato e la città dove si svolgerà l'evento, la categoria (che può essere: sportiva, musicale, artistica/teatrale o eventi sul ghiaccio) e il genere (football,rock,pop, hockey, teatro,...), e una descrizione generale di cosa tratta l'evento. L'utente sarà in grado di visualizzare le statistiche richieste nei requisiti del progetto: 
1. Numero totale di eventi per ogni Stato
2. Numero di eventi raggruppati per genere
3. Numero medio/massimo/minimo di eventi mensili

Inoltre l'utente può filtrare opzionalmente gli eventi per i seguenti elementi:
1. Uno o più tipi di evento
2. Uno o più stati 
3. Uno o più generi
4. Periodo personalizzato
5. Prezzo minimo e prezzo massimo


# Diagrammi UML
<b>Diagramma dei Casi d'Uso</b>



![Diagramma dei Casi D'Uso.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20dei%20Casi%20D'Uso.png?raw=true)



<b>Diagramma delle Sequenze</b>



![Diagramma delle sequenze Filtro_Statistiche.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20delle%20Sequenze/Diagramma%20delle%20sequenze%20Filtro_Statistiche.png?raw=true)



![Diagramma delle sequenze visualizza_tutti_eventi.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20delle%20Sequenze/Diagramma%20delle%20sequenze%20visualizza_tutti_eventi.png?raw=true)



![Diagramma delle sequenze visualizza_statistiche_stati.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20delle%20Sequenze/Diagramma%20delle%20sequenze%20visualizza_statistiche_stati.png?raw=true)



<b>Diagramma delle Classi</b>



![progetto.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20delle%20Classi/progetto.png?raw=true)



![Controller.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20delle%20Classi/Controller.png?raw=true)



![Service.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20delle%20Classi/Service.png?raw=true)



![Data_Model.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20delle%20Classi/Data_Model.png?raw=true)

![Filter.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20delle%20Classi/Filter.png?raw=true)





![Stats.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20delle%20Classi/Stats.png?raw=true)



![Exception.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20delle%20Classi/Exception.png?raw=true)



![Total_Class_diagram.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20delle%20Classi/Total_Class_diagram.png?raw=true)




# Rotte
Le richieste che l'utente può effettuare tramite Postman devono essere effettuate all'indirizzo localhost:8080.


# Rotte relative alla lettura dati

| Tipo | Rotta          | Descrizione                                                  |
| :--: | -------------- | ------------------------------------------------------------ |
| GET  | "/getData"     | Recupera tutti i dati degli eventi di TicketMaster           |
| GET  | "/getMetaData" | Recupera i metadati                                          |
| POST | "/postData"    | Posta i dati ricevuti da TicketMaster nella struttura die metadati |



# Rotte relative alle Statistiche

| Tipo | Rotta                      | Descrizione                                                  |
| :--- | :------------------------- | :----------------------------------------------------------- |
| POST | "/stats/numEvents"         | Recupera il numero di eventi per ogni StateCode              |
| POST | "/stats/numEventsGenre"    | Recupera il numero di eventi per ogni genere                 |
| POST | "/stats/getStates"         | Recupera tutti gli StateCode presenti nel vettore degli eventi |
| POST | "/stats/numEventsInterval" | Recupera gli eventi minimo, massimo e medio per un intervallo di date personalizzato |


### Filtri utilizzabili in tutte le rotte delle statistiche

| BodyParameters | Description                                      | Type   | Example          |
| -------------- | ------------------------------------------------ | ------ | ---------------- |
| "segment"      | Filtra gli eventi per il tipo                    | String | "music, sport"   |
| "genre"        | Filtra gli eventi per il genere                  | String | "Rock, Baseball" |
| "state"        | Filtra gli eventi per il codice dello stato      | String | "FL,LA"          |
| "priceMin"     | Filtra gli eventi per un range di prezzo minimo  | float  | "40.6"           |
| "priceMax"     | Filtra gli eventi per un range di prezzo massimo | float  | "100.8"          |
| "startDate"    | Filtra gli eventi a partita dalla data inserita  | String | "01/04/2021"     |
| "endDate"      | Filtra gli eventi fino alla data inserita        | String | "31/12/2021"     |


# Gestione Eccezioni


# Test


# Tecnologie utilizzate


- Software utilizzati:

  [Eclipse](https://www.eclipse.org/downloads/) - IDE per scrivere il codice in Java 

  [SpringBoot](https://spring.io/projects/spring-boot) - framework backend Java

  [PostMan](https://www.postman.com) - Software per l'API Testing

  [Draw.io](https://app.diagrams.net) - utilizzato per il diagramma delle classi e delle sequenze
  
  [Typora](https://typora.io) - usato per scrivere il ReadMe.md in formato Markdown

- TicketMaster API:

  [TicketMaster](https://developer.ticketmaster.com/products-and-docs/apis/discovery-api/v2/) - Documentazione API TicketMaster 






# Autori
Il progetto è stato sviluppato da:

@ Antonio Colasurdo & @ Daniele Sergiacomi.
