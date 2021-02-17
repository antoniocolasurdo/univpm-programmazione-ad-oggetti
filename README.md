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

1) visualizzazione di statistiche filtrate



![Diagramma delle sequenze Filtro_Statistiche.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20delle%20Sequenze/Diagramma%20delle%20sequenze%20Filtro_Statistiche.png?raw=true)

2) visualizzazione di tutti gli eventi

![Diagramma delle sequenze visualizza_tutti_eventi.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20delle%20Sequenze/Diagramma%20delle%20sequenze%20visualizza_tutti_eventi.png?raw=true)



3) visualizzazione delle statistiche per ogni stato Mensili

![Diagramma delle sequenze visualizza_statistiche_stati.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20delle%20Sequenze/Diagramma%20delle%20sequenze%20visualizza_statistiche_stati.png?raw=true)



<b>Diagramma delle Classi:</b>

​             <b>Package Progetto</b>



![progetto.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20delle%20Classi/progetto.png?raw=true)



​             <b>Package Controller</b>



![Controller.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20delle%20Classi/Controller.png?raw=true)

Il package ***controller*** contiene le classi:

1) *ServiceController* che contiene 3 rotte, una per leggere i dati da TicketMaster e creare la struttura degli eventi con attributi e proprietà richieste dalle specifiche di progetto (*readData*), una per recuperare i metadati (*getMetaData*), e una per recuperare i dati di tutti gli eventi letti da TicketMaster (*getData*).

2) *StatsController* che contiene 4 rotte, una per recuperare il numero di eventi di ogni stato (*getNumEvents*), una per recuperare il numero di eventi per genere (*getNumEventsGenre*), una per recuperare l'insieme degli StateCode di tutti gli eventi (*getStates*), e una per recuperare l'insieme degli StateCode di tutti gli eventi (*numEventsInterval*).



​             <b>Package Service</b>



![Service.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20delle%20Classi/Service.png?raw=true)

Il package ***controller*** contiene l'interfaccia Service che estende ServiceImpl, e contiene 3 metodi:

1) readData: Metodo di recupero dei dati da Ticket Master

2) getMetaData: Metodo di recupero dei metadati utilizzati nel modello dati del progetto

3) getData: Metodo di recupero di tutti i dati recuperati da Ticket Master



​             <b>Package Data_Model</b>



![Data_Model.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20delle%20Classi/Data_Model.png?raw=true)

Il package ***Data_Model*** contiene le classi che definiscono gli oggetti utilizzati: ovvero le classi *Dates*, *PriceRange*, *Venue* per contenere data, ora, range di prezzo, città e stato di ogni evento.

Inoltre si è deciso di utilizzare una classe astratta *Event* per contenere nome, ID, family, info, oltre che le informazioni per data, prezzo, locazione dalle altre classi; La classe è astratta in quando utilizza il metodo astratto *getGenre* che viene utilizzato da *Sports*, *Music*, *Arts&Theatre*, *Miscellaneous* che sono le specializzazioni della categoria dell'evento (segment). Ognuna di quelle sottoclassi specializzate ha il proprio genere.



​             <b>Package Filter</b>



![Filter.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20delle%20Classi/Filter.png?raw=true)

Il package **Filter** contiene la classe astratta *Filter* che estende i vari filtri: *StateFilter* per filtrare per uno o più stati, *DateFilter* per filtrare per un certo intervallo di tempo, *SegmentFilter* per filtrare per i 4 segment, *GenreFilter* per filtrare per uno o più generi, *PriceRangeFilter* per filtrare per un certo intervallo di prezzo. 

E' presente la classe *FilterManager* che prende tutti i filtri prima elencati e ne verifica la validità.



​             <b>Package Stats</b>



![Stats.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20delle%20Classi/Stats.png?raw=true)

Il package ***stats*** contiene l'interfaccia *Stats* che estende la classe *StatsImpl*, che contiene 4 metodi:
*GetStates* si occupa di restituire il codice dello stato in cui si terranno gli eventi.                                                                                               *GetNumEvents* si occupa di restituire il numero di eventi presenti in ogni stato.
*GetNumEventsGenre* restituisce il numero di eventi presenti raggruppati per segmento e genere.
*numEventsInterval* Restituisce l'insieme dei valori minimo, massimo e medio degli eventi mensilmente e con date personalizzate.



​             <b>Package Exception</b>



![Exception.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20delle%20Classi/Exception.png?raw=true)

Abbiamo gestito le eccezioni creando nove nuove classi:

1) *WrongEndDateException*: viene generata quando l'utente inserisce una data finale inferiore alla data iniziale

2) *WrongStartDateException*: viene generata quando l'utente inserisce una data inferiore alla lettura dei dati di TicketMaster

3) *WrongFormatDateException*: viene generata quando l'utente inserisce una data in un formato non valido

4) *WrongNegativePriceMinException*: viene generata quando l'utente inserisce un prezzo minimo minore di 0

5) *WrongPriceMaxException*: viene generata quando l'utente inserisce un prezzo massimo che è minore di quello minimo

6) *WrongStateException*: viene generata quando l'utente inserisce un nome errato per il codice dello stato

7) *WrongSegmentException*: viene generata quando l'utente inserisce un nome errato per il segment

8) *WrongGenreException*: viene generata quando l'utente inserisce un genere non presente oppure scritto in modo erroneo

9) *GenericException*: viene generata per prevenire errori non gestiti



​             <b>Diagramma delle Classi totale</b>



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

Abbiamo gestito le eccezioni creando nove nuove classi:

1) *WrongEndDateException*: viene generata quando l'utente inserisce una data finale inferiore alla data iniziale

2) *WrongStartDateException*: viene generata quando l'utente inserisce una data inferiore alla lettura dei dati di TicketMaster

3) *WrongFormatDateException*: viene generata quando l'utente inserisce una data in un formato non valido

4) *WrongNegativePriceMinException*: viene generata quando l'utente inserisce un prezzo minimo minore di 0

5) *WrongPriceMaxException*: viene generata quando l'utente inserisce un prezzo massimo che è minore di quello minimo

6) *WrongStateException*: viene generata quando l'utente inserisce un nome errato per il codice dello stato

7) *WrongSegmentException*: viene generata quando l'utente inserisce un nome errato per il segment

8) *WrongGenreException*: viene generata quando l'utente inserisce un genere non presente oppure scritto in modo erroneo

9) *GenericException*: viene generata per prevenire errori non gestiti


# Test

Di seguito sono elencati i test unitari inseriti nel progetto:

| Nome della routine di test  | Descrizione                                                  |
| --------------------------- | ------------------------------------------------------------ |
| readDataTicketMaster        | Verifica se i dati letti da Ticket Master sono dello stesso numero richiesto |
| getNumEventWithoutAnyFilter | Verifica se sono recuperati gli eventi ai fini delle statistiche |
| filterWithException         | Verifica eccezione sul filtro data iniziale                  |
| getStatesNotIsNull          | Verifica che il recupero degli stati non sia nullo           |



# Tecnologie utilizzate


- Software utilizzati:

  [Eclipse](https://www.eclipse.org/downloads/) - IDE per scrivere il codice in Java 

  [SpringBoot](https://spring.io/projects/spring-boot) - framework backend Java

  [PostMan](https://www.postman.com) - Software per l'API Testing

  [UMLDesigner ](http://www.umldesigner.org/) - utilizzato per il diagramma dei casi d'uso

  [Draw.io](https://app.diagrams.net) - utilizzato per il diagramma delle classi e delle sequenze

  [Typora](https://typora.io) - usato per scrivere il ReadMe.md in formato Markdown

- TicketMaster API:

  [TicketMaster](https://developer.ticketmaster.com/products-and-docs/apis/discovery-api/v2/) - Documentazione API TicketMaster 






# Autori
Il progetto è stato sviluppato da:

@ Antonio Colasurdo & @ Daniele Sergiacomi.
