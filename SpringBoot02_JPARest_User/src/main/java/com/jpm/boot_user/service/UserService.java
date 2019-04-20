/**
 * 
 */
package com.jpm.boot_user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpm.boot_user.dao.IUserDao;
import com.jpm.boot_user.entity.User;
import com.jpm.boot_user.exception.MyUserException;

/**
 * @author Smita B Kumar
 *
 */
//prep-work -> annotate Service component
@Service("userService")
public class UserService implements IUserService {
	
//prep work 2-> inject Dao Object
	@Autowired
	private IUserDao userDao;
	
	@Override
	public User getUserById(Long userId) throws MyUserException {
//prep work 4-> call and return dao method in specific service method
		return userDao.getUserById(userId);
	}
	

	
	@Override
	@Transactional
	public User addUser(User user) throws MyUserException {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	@Transactional
	public User updateUser(User user) throws MyUserException {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}



	@Override
	@Transactional
	public User deleteUser(Long userId) throws MyUserException {
		// TODO Auto-generated method stub
		return userDao.deleteUser(userId);
	}



	@Override
	public List<User> getUserList() throws MyUserException {
		// TODO Auto-generated method stub
		return userDao.getUserList();
	}

}
