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

Il programma permette di vedere tutti gli eventi degli USA recuperando i dati tramite una chiamata API da TicketMaster; l'utente può visualizzare l'id dell'evento, il nome dell'evento, la data, l'ora, il range di prezzo del biglietto, lo stato e la città dove si svolgerà l'evento, la categoria (che può essere: sportiva, musicale, artistica/teatrale o eventi sul ghiaccio) e il genere (football,rock,pop, hockey, teatro,...), e una descrizione generale di cosa tratta l'evento. I dati possono essere filtrati per uno o più stati, un certo intervallo di data, una categoria o uno o più generi appartenenti ad una determinata categoria. Sarà inoltre possibile vedere delle statistiche quali:
Il massimo, minimo, media di eventi mensili, il numero totale di eventi e il numero totale di eventi filtrato per genere.

# Diagrammi UML
<b>Diagramma dei Casi d'Uso</b>



![Diagramma dei Casi D'Uso.png](https://github.com/antoniocolasurdo/univpm-programmazione-ad-oggetti/blob/main/Img/Diagramma%20dei%20Casi%20D'Uso.png?raw=true)



<b>Diagramma delle Sequenze</b>



![Diagramma delle sequenze Filtro_Statistiche](C:\Users\serda\eclipse-workspace\univpm-programmazione-ad-oggetti\Img\Diagramma delle Sequenze\Diagramma delle sequenze Filtro_Statistiche.png)



![Diagramma delle sequenze visualizza_tutti_eventi](C:\Users\serda\eclipse-workspace\univpm-programmazione-ad-oggetti\Img\Diagramma delle Sequenze\Diagramma delle sequenze visualizza_tutti_eventi.png)



![Diagramma delle sequenze visualizza_statistiche_stati](C:\Users\serda\eclipse-workspace\univpm-programmazione-ad-oggetti\Img\Diagramma delle Sequenze\Diagramma delle sequenze visualizza_statistiche_stati.png)



<b>Diagramma delle Classi</b>



![progetto](C:\Users\serda\eclipse-workspace\univpm-programmazione-ad-oggetti\Img\Diagramma delle Classi\progetto.png)



![Controller](C:\Users\serda\eclipse-workspace\univpm-programmazione-ad-oggetti\Img\Diagramma delle Classi\Controller.png)



![Service](C:\Users\serda\eclipse-workspace\univpm-programmazione-ad-oggetti\Img\Diagramma delle Classi\Service.png)



![Data_Model](C:\Users\serda\eclipse-workspace\univpm-programmazione-ad-oggetti\Img\Diagramma delle Classi\Data_Model.png)



![Filter](C:\Users\serda\eclipse-workspace\univpm-programmazione-ad-oggetti\Img\Diagramma delle Classi\Filter.png)





![Stats](C:\Users\serda\eclipse-workspace\univpm-programmazione-ad-oggetti\Img\Diagramma delle Classi\Stats.png)



![Total_Class_diagram](C:\Users\serda\eclipse-workspace\univpm-programmazione-ad-oggetti\Img\Diagramma delle Classi\Total_Class_diagram.png)




# Rotte
Le richieste che l'utente può effettuare tramite Postman devono essere effettuate all'indirizzo localhost:8080.


# Rotte relative alla lettura dati

| Tipo | Rotta          | Descrizione                                                  |
| :--: | -------------- | ------------------------------------------------------------ |
| GET  | "/getData"     | Recupera tutti i dati degli eventi di TicketMaster           |
| GET  | "/getMetaData" | Recupera i metadati                                          |
| POST | "/postData"    | Posta i dati ricevuti da TicketMaster nella struttura die metadati |



# Rotte relative ai Filter


# Rotte relative alle Stats


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

- Implentazione per Java (librerie utilizzate):





# Autori
Il progetto è stato sviluppato da:

@ Antonio Colasurdo & @ Daniele Sergiacomi.
