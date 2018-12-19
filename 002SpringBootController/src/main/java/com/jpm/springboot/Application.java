package com.jpm.springboot;
/**
 * @author Smita */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/*Running the Application
We use a Spring Boot Application class to launch our application.*/
@SpringBootApplication
@ComponentScan("com.jpm.springboot")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

