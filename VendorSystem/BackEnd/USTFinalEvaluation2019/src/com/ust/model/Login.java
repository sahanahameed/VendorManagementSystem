/*BEAN LOGIN*/

package com.ust.model;

//Bean representing Class Login
public class Login {

	// instance variables
	private int userId;
	private String username;
	private String password;

	// default Constructor
	public Login() {
		super();
	}

	// parameterized constructor
	public Login(int userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	// getters and setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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

	// toString method
	@Override
	public String toString() {
		return "Login [userId=" + userId + ", username=" + username
				+ ", password=" + password + "]";
	}

}
