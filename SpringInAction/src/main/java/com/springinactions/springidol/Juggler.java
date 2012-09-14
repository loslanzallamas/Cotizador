package com.springinactions.springidol;

public class Juggler implements Performer {

	private int beanBags = 3;
	
	public Juggler() {
		// TODO Auto-generated constructor stub
	}
	
	public Juggler(int beanBags) {
		this.beanBags = beanBags;
	}
	
	public void perform() throws PerformanceException {
		System.out.println("JUGGLING " + beanBags + " BEANBAGS");
	}

}
