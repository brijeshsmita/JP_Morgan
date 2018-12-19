package com.jpm.springboot.controller;
/**
 * @author Smita */
/*Todo Controller
The Todo Controller has a simple method to retrieve the list of todos and populate it into the model. It redirects to the list-todos view.
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.jpm.springboot.service.ITodoService;
@Controller
@SessionAttributes("name")
public class TodoController {
    @Autowired
    ITodoService service;
    @RequestMapping(value="/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model){
        String name = (String) model.get("name");
        model.put("todos", service.retrieveTodos(name));
        return "list-todos";
    }
}

