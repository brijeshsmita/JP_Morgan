package com.jpm.springboot.service;
/** * @author Smita */
/*Our todo service uses a simple ArrayList to store a list of todos. It offers a method to retrieve the todos.
*/
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jpm.springboot.model.Todo;
@Service
public class TodoService implements ITodoService{
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;
    static {
        todos.add(new Todo(1, "smita", "Learn Spring Boot 2.2", new Date(),
                false));
        todos.add(new Todo(2, "smita", "Learn Artificial Intelligent", new Date(), false));
        todos.add(new Todo(3, "smita", "Learn Data Science", new Date(),
                false));
    }
    @Override
    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
}