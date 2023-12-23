package net.javaguides.sms.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class UserDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_Id")
	private int userId;
	
	@Column(name="user_name",nullable = false, length =  100)
	private String userName;
	@Column(name="password", nullable = false, length = 15)
	private String password;
	private String Email;
	private String about;
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(int userId, String userName, String password, String email, String about) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		Email = email;
		this.about = about;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userName=" + userName + ", password=" + password + ", Email=" + Email
				+ ", about=" + about + "]";
	}
	
	
	
	
}
