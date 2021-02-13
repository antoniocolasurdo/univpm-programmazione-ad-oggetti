package it.univpm.progetto.model;

public class MusicSegment extends Segment {

	public MusicSegment() {
		super("Music");
	}
	
	public MusicSegment(String id) {
		this();
		setId(id);
	}

}