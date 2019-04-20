/**
 * 
 */
package com.jpm.boot_user.service;

import java.util.List;

import com.jpm.boot_user.entity.User;
import com.jpm.boot_user.exception.MyUserException;

/**
 * @author Smita B Kumar
 *
 */
public interface IUserService {
	public User getUserById(Long userId) throws MyUserException;
	public List<User> getUserList()throws MyUserException;
	public User addUser(User user) throws MyUserException;

	public User updateUser(User user)throws MyUserException;
	public User deleteUser(Long userId)throws MyUserException; 
}
