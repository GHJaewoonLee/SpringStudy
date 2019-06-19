package com.kitri.hello3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class HelloMain {

	public static void main(String[] args) {
		// HelloServices helloServices = new HelloServicesKOR();
		// HelloServices helloServices = new HelloServicesENG();
		
		// 2.x
		// Resource resource = new ClassPathResource("com/kitri/hello3/ApplicationContext.xml");
		// BeanFactory factory = new XmlBeanFactory(resource); 
		// HelloServices helloServices = (HelloServices) factory.getBean("helloServices");
		
		// above 3
		System.out.println("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/kitri/hello3/ApplicationContext.xml");
		System.out.println("Read setting");
		HelloServices helloServices = context.getBean("helloServices", HelloServices.class);
		System.out.println("Get service");
		
		String msg = helloServices.Hello("sdfsdfasdv");
		
		System.out.println(msg);
		
//		HelloServices h1 = new HelloServicesKOR();
//		HelloServices h2 = new HelloServicesKOR();
//		System.out.println(h1 + " " + h2);
		
		HelloServices h3 = context.getBean("helloServices", HelloServices.class);
		System.out.println("==================================");
		HelloServices h4 = context.getBean("helloServices", HelloServices.class);
		System.out.println(h3 + " " + h4);
	}
}

/*
	2.x : 무조건 xml
	=============
	3 이상 : xml 또는 annotation
*/

// XML 파일을 통해 context를 만드는 시점에서 객체가 생성 (기본적으로 Singleton 적용)
// Prototype은 getBean()이 호출되는 순간에 객체 생성