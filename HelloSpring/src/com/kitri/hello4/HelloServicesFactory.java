package com.kitri.hello4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


// Spring이 자동적으로 Singleton 적용

@Configuration
public class HelloServicesFactory {

	@Bean(name = {"HelloServices", "HS"})
	@Scope(value = "prototype")
	public HelloServices getHelloservices() {
		return new HelloServicesKOR();
	}
}
