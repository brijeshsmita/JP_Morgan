package com.jpm.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jpm.springboot.service.LoginService;

/*Login Controller
public String showLoginPage(ModelMap model): Mapped to the \login Get Method, this method shows the login page.
@Autowired LoginService service: LoginService has the validation logic.
showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String passwordMapped to the \login Post Method, this method validates the user id and password. Redirects to welcome page if login is successful.
*/
@Controller
@SessionAttributes("name")
public class LoginController {
    @Autowired
    LoginService service;
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "login";
    }
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){
        boolean isValidUser = service.validateUser(name, password);
        if (!isValidUser) {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }
        model.put("name", name);
        model.put("password", password);
        return "welcome";
    }
}
