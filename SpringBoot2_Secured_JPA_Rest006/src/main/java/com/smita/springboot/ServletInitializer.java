package com.smita.springboot;
/** @author Smita **/
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
public class ServletInitializer extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBoot2SecuredJpaRest006Application.class);
		//return application.sources(JavaApplication.class);//for stand-alone java application
	}
}

