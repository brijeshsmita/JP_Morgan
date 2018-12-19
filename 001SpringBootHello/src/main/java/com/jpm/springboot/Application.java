package com.jpm.springboot;

import java.util.Iterator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
//entry point
@SpringBootApplication
@ComponentScan("com.jpm")
public class Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Application.class, args);
		for (String name: context.getBeanDefinitionNames()) {
			System.out.println("======****"+name);
		}
	}

}

