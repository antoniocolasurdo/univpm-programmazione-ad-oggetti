package it.univpm.progetto.model;

public class TicketMasterEvent {

	private String name;
	private String type;
	private String id;
	private boolean test;
	private String url;
	private String locale;
	private String info;
	private String pleaseNote;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isTest() {
		return test;
	}
	public void setTest(boolean test) {
		this.test = test;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getPleaseNote() {
		return pleaseNote;
	}
	public void setPleaseNote(String pleaseNote) {
		this.pleaseNote = pleaseNote;
	}
	
/*	
    "sales" : {
      "public" : {
        "startDateTime" : "2020-12-22T16:00:00Z",
        "startTBD" : false,
        "startTBA" : false,
        "endDateTime" : "2021-01-31T02:00:00Z"
      },
      "presales" : [ {
        "startDateTime" : "2020-12-15T16:00:00Z",
        "endDateTime" : "2020-12-22T05:59:00Z",
        "name" : "Feld Preferred Presale"
      }, {
        "startDateTime" : "2020-12-17T16:00:00Z",
        "endDateTime" : "2020-12-22T05:59:00Z",
        "name" : "TM/Venue Presale"
      } ]
    },
    "dates" : {
      "start" : {
        "localDate" : "2021-01-30",
        "localTime" : "19:00:00",
        "dateTime" : "2021-01-31T01:00:00Z",
        "dateTBD" : false,
        "dateTBA" : false,
        "timeTBA" : false,
        "noSpecificTime" : false
      },
      "timezone" : "America/Chicago",
      "status" : {
        "code" : "onsale"
      },
      "spanMultipleDays" : false
    },
    "classifications" : [ {
      "primary" : true,
      "segment" : {
        "id" : "KZFzniwnSyZfZ7v7nE",
        "name" : "Sports"
      },
      "genre" : {
        "id" : "KnvZfZ7vA7k",
        "name" : "Motorsports/Racing"
      },
      "subGenre" : {
        "id" : "KZazBEonSMnZfZ7vFt7",
        "name" : "Motorsports/Racing"
      },
      "type" : {
        "id" : "KZAyXgnZfZ7v7nI",
        "name" : "Undefined"
      },
      "subType" : {
        "id" : "KZFzBErXgnZfZ7v7lJ",
        "name" : "Undefined"
      },
      "family" : false
    } ],
    "promoter" : {
      "id" : "2515",
      "name" : "FELD MOTORSPORTS",
      "description" : "FELD MOTORSPORTS / NTL / USA"
    },
    "promoters" : [ {
      "id" : "2515",
      "name" : "FELD MOTORSPORTS",
      "description" : "FELD MOTORSPORTS / NTL / USA"
    } ],
    "info" : "Monster Jam is an action-packed motorsport with world-class athletes locked in intense competitions of speed and skill. Witness heated rivalries, high-flying stunts and fierce head-to-head battles for the Event Championship. Engineered to perfection, these 12,000-pound monster trucks, including the legendary Grave Digger and Monster Energy, push all limits in Freestyle, Skills Challenge and Racing competitions. This is full-throttle family fun. This. Is. Monster Jam. You cannot split ticket PODs among unacquainted persons. Doing so may invalidate these tickets for entry.",
    "pleaseNote" : "All guests age 2 & older are required to have a ticket. Unless otherwise exempted by law, guests must wear a face covering except when actively eating and drinking. No costumes for guests 14 & older. This event uses pod seating. Pod seating was developed for the safety and wellness of our guests and to maintain social distancing. Pods are available in groups of 1-8 and will be physically distanced from one another. Pods must be purchased in their entirety and may not be divided. Tickets in a pod may not be sold or transferred to anyone other than family and trusted acquaintances who have chosen to attend the event together, unless all such tickets are being sold or transferred to one party. Sitting in any seat outside your pod is not permitted. Limit 1 pod, maximum 8 tickets per transaction. All pods are subject to availability. Violation of ticketing policies will void your tickets. Prices are subject to change. Competitors are subject to change.",
    "priceRanges" : [ {
      "type" : "standard",
      "currency" : "USD",
      "min" : 20.0,
      "max" : 110.0
    } ],
    "products" : [ {
      "name" : "Monster Jam 2021 – Official Souvenir Tag",
      "id" : "G5dIZp9J0MsU2",
      "url" : "https://www.ticketmaster.com/monster-jam-2021-official-souvenir-tag-houston-texas-01-30-2021/event/3A005979A4DF1D8F",
      "type" : "Upsell",
      "classifications" : [ {
        "primary" : true,
        "segment" : {
          "id" : "KZFzniwnSyZfZ7v7n1",
          "name" : "Miscellaneous"
        },
        "genre" : {
          "id" : "KnvZfZ7v7ll",
          "name" : "Undefined"
        },
        "subGenre" : {
          "id" : "KZazBEonSMnZfZ7vAv1",
          "name" : "Undefined"
        },
        "type" : {
          "id" : "KZAyXgnZfZ7v7nJ",
          "name" : "Upsell"
        },
        "subType" : {
          "id" : "KZFzBErXgnZfZ7vAke",
          "name" : "Merchandise Voucher"
        },
        "family" : false
      } ]
*/

}