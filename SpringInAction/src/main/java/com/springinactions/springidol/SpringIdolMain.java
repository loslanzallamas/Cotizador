package com.springinactions.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIdolMain {

	/**
	 * @param args
	 * @throws PerformanceException 
	 */
	public static void main(String[] args) throws PerformanceException {
		
		ApplicationContext cx = new ClassPathXmlApplicationContext("META-INF/spring/spring-idol.xml");
		Performer performer = (Performer) cx.getBean("kenny2");
		performer.perform();
		
		performer = (Performer) cx.getBean("hank");
		performer.perform();

	}

}
