package com.kitri.hello3;

public class HelloServicesKOR implements HelloServices {

	private HelloDao helloDao;
	
	public HelloServicesKOR(HelloDao helloDao) {
		this.helloDao = helloDao;
	}
	
//	public void setHelloDao(HelloDao helloDao) {
//		this.helloDao = helloDao;
//	}

//	public HelloServicesKOR() {
//		System.out.println("KOR Constructor");
//	}
	
	public String Hello(String name) {
		return name + " 안녕하세요. \n" + helloDao.getGreeting();
	}
}
