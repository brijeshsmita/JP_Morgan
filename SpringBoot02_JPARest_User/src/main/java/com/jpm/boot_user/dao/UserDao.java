/**
 * 
 */
package com.jpm.boot_user.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jpm.boot_user.entity.User;
import com.jpm.boot_user.exception.MyUserException;

/**
 * @author Smita B Kumar
 *
 */
// prep-work - annotate Dao with Repository
@Repository
public class UserDao implements IUserDao {
	// peristenceContext autowired
	// prep-work 2 -> @PersistenceContext EnttityManager Object
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jpm.boot_user.dao.IUserDao#getUserById(int)
	 */
	@Override
	public User getUserById(Long userId) {
		// User user = new User(userId, "Mona", "password", "admin");
		// return user;
		return entityManager.find(User.class, userId);
	}

	@Override
	public User addUser(User user) {
		System.out.println("User Added in Database : " + user);
		entityManager.persist(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		System.out.println("User Update in Database : " + user);
		return entityManager.merge(user);
	}

	// listUser
	public List<User> getUserList() {
		Query query = entityManager.createQuery("from User");
		return query.getResultList();
	}
	// delete user
	/*
	 * public boolean deleteUser(Long userId) throws EmployeeException { User user
	 * =getUserById(userId); if(user!=null) return false; else {
	 * entityManager.remove(user); return true; } }
	 */

	@Override
	public User deleteUser(Long userId){
		User user = getUserById(userId);
		if (user != null) {
			System.out.println("Trying to remove user from Database : " + user);
			entityManager.remove(user);
			user = null;
		} else {
			System.out.println("User with id " + userId + " Not Found");
		}
		return user;
	}
}
