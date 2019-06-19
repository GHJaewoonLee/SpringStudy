package com.kitri.hello1;

public class HelloMain {

	public static void main(String[] args) {
		HelloServicesKOR helloServicesKOR = new HelloServicesKOR();
		String msg = helloServicesKOR.HelloKOR("sdfsdfasdv");
		
		System.out.println(msg);
		
		HelloServicesENG helloServicesENG = new HelloServicesENG();
		msg = helloServicesENG.HelloENG("sdfsdfasdv");
		
		System.out.println(msg);
	}
}
