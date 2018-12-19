/**
 * 
 */
package com.jpm.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author brije
 *
 */
//lets make it a controller
@RestController
public class HelloController {
	
	//which request it will handle
	//it will handle hello request- use @RequestMapping
	@RequestMapping("/")
	public String index() {
		return "This is the index page";
	}
	@RequestMapping("/hello")
	public String hello() {
		return "Hello ,Welcome to the auto-configurable world of Spring boot";
	}

}
