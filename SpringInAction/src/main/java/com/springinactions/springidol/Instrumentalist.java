package com.springinactions.springidol;

public class Instrumentalist implements Performer {

	public Instrumentalist() {
		// TODO Auto-generated constructor stub
	}
	
	public void perform() throws PerformanceException {
		System.out.println("Playing " + song + " : ");
		instrument.play();
	}
	
	private String song;
	
	//inject song
	public String getSong() {
		return song;
	}
	
	public void setSong(String song) {
		this.song = song;
	}
	
	public String screamSong(){
		return song;
	}
	
	private Instrument instrument;
	
	//inject instrument
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}
