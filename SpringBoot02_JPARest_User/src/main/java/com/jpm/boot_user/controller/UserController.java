/**
 * 
 */
package com.jpm.boot_user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpm.boot_user.entity.User;
import com.jpm.boot_user.exception.MyUserException;
import com.jpm.boot_user.service.IUserService;

/**
 * @author Smita B Kumar
 *@RequestMapping (@Path)
 *	-used at class level
 *	-method level
 *-spring 4.3 onward method level request mapping made more simpler
 *@GetMapping -Get method
 *@PostMapping -Post method
 *@PutMapping -Put method
 *@DeleteMapping -Delete method
 *http://localhost:8080/
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private IUserService userService;
	//http://localhost:8080/api/users
	@ResponseBody
	@GetMapping("/")
	public String greetUser() {
		return "Hello From Spring Boot Rest User Application";
	}
	//http://localhost:8080/api/users/userList
	@GetMapping(path="/userList",produces="application/json")
	public List<User> getAllUsers() throws MyUserException{
		return userService.getUserList();
		/*List<User> userList = new ArrayList<>();
		userList.add(new User(22L, "admin", "admin", "admin@gmail.com"));
		return userList;*/
	}
//http://localhost:8080/api/users/getUser/1	
	@GetMapping(path="/getUser/{userId}" ,produces="application/json")
	//value passed along with url ,variable passed along with path
	public User getUserById(@PathVariable Long userId) throws MyUserException {
		return userService.getUserById(userId);
	}
	//http://localhost:8080/api/users/addUser
	@PostMapping(path="/addUser")
	public String addUser(@RequestBody User user) throws MyUserException {
		User addedUser = userService.addUser(user);
		if(addedUser!=null)
			return "User Added with unique User Id : "+addedUser.getUserId();
		return "Adding User Failed!!";
	}
	// http://localhost:8080/api/users/deleteUser/1
	@DeleteMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable Long userId) throws MyUserException {
		System.out.println("Record Deleted with Id : "+userId);
		User delUser = userService.deleteUser(userId);
		if(delUser==null)
			return "User Deleted";
		return "Removing User Failed!!";
	}
	// http://localhost:8080/api/users/updateUser/1
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody User user,
			@PathVariable Long id) throws MyUserException {

		User userFound = userService.getUserById(id);

		if (userFound==null)
			return ResponseEntity.notFound().build();

		user.setUserId(id);
		
		userService.updateUser(user);
		System.out.println("Record Updated : "+user);
		return ResponseEntity.ok(user);
	}
	
}

/*
 * Class ResponseEntity<T>. public class ResponseEntity<T> extends HttpEntity<T> Extension of HttpEntity that adds a HttpStatus status code. Used in RestTemplate as well @Controller methods. Defines a builder that adds a body to the response entity. Defines a builder that adds headers to the response entity.
 */




