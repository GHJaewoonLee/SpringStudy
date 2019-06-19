package com.kitri.hello2;

public class HelloMain {

	public static void main(String[] args) {
//		HelloServices helloServices = new HelloServicesKOR();
		HelloServices helloServices = new HelloServicesENG();
		
		String msg = helloServices.Hello("sdfsdfasdv");
		
		System.out.println(msg);
	}
}
