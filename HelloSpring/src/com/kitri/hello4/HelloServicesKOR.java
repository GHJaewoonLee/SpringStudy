package com.kitri.hello4;

public class HelloServicesKOR implements HelloServices {

	public HelloServicesKOR() {
		System.out.println("KOR Constructor");
	}
	
	public String Hello(String name) {
		return name + " 안녕하세요.";
	}
}
