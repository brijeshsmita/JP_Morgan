/**
 * 
 */
package com.jpm.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author brije
 *
 */
@Controller
public class HelloController {
	@RequestMapping(path="/",method=RequestMethod.GET)
	public String showIndex() {
		return "Index Page";
	}
}
