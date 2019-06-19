package com.kitri.hello4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


// XML (Spring 2, ...)
// XML + Annotation (Spring 3)
// Annotation (Sprint 4, 5 ..., Boot)

public class HelloMain {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(HelloServicesFactory.class);
		HelloServices helloServices = context.getBean("HS", HelloServices.class);
		
		String msg = helloServices.Hello("sdfsdfasdv");
		
		System.out.println(msg);
		
		HelloServices helloServices1 = context.getBean("HS", HelloServices.class);
		HelloServices helloServices2 = context.getBean("HelloServices", HelloServices.class);
		System.out.println(helloServices1 + " " + helloServices2);
	}
}