package com.springinactions.springidol;

public class Stage {

	public Stage() {
		// TODO Auto-generated constructor stub
	}
	
	private static class StageSingletonHolder {
		//Lazily loads instance
		static Stage instance = new Stage();
	}
	
	public static Stage getInstance() {
		//Return instance
		return StageSingletonHolder.instance;
	}
	
}
