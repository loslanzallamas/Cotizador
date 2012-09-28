package com.springinactions.knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
		
		Knight knight = (Knight) context.getBean("knight");
		
		knight.embarkOnQuest();

	}

}
