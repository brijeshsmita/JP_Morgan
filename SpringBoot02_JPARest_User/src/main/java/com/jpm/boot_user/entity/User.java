/**
 * 
 */
package com.jpm.boot_user.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Smita B Kumar
 *
 */
@Entity
@Table(name="user_ng_rest")
public class User implements Serializable{
	private static final long serialVersionUID = 6325307718376939175L;
	@Id
	@Column(name="user_id")
	private Long userId;
	private String username;
	private String password;
	private String email;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Long userId, String username, String password, String role) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = role;
	}

	public User(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.email = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
