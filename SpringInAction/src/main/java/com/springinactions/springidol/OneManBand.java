package com.springinactions.springidol;

import java.util.Collection;

public class OneManBand implements Performer {

	public void perform() throws PerformanceException {
		for(Instrument instrument:instruments){
			instrument.play();
		}
	}
	
	private Collection<Instrument> instruments;
	
	//inject instrument collection
	public void setInstruments(Collection<Instrument> instruments) {
		this.instruments = instruments;
	}

}
