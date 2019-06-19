package com.kitri.hello3;

public class HelloServicesENG implements HelloServices {

	public HelloServicesENG() {
		System.out.println("ENG Constructor");
	}
	
	public String Hello(String name) {
		return name + " Hello.";
	}
}
