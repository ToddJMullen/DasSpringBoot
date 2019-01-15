package com.boot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.boot.controller.HomeController;

public class AppTest{

	@Test
	public void testApp(){
		HomeController hc = new HomeController();
		String str = hc.home();
		assertEquals("This is the Das Spring Boot HomeController::home()", str);

    }

}//AppTest
