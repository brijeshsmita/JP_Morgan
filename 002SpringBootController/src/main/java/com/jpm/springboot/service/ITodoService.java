/**
 * 
 */
package com.jpm.springboot.service;

import java.util.List;

import com.jpm.springboot.model.Todo;

/**
 * @author Smita
 *
 */
public interface ITodoService {

	List<Todo> retrieveTodos(String user);

}
