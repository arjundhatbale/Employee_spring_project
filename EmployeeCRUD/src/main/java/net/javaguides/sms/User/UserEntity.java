package net.javaguides.sms.User;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import net.javaguides.sms.post.Post;

@Entity
@Table(name="user_entity")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_Id")
	private int userId;
	
	@NotNull
	@Size(min = 4, message="user name must be minimum 3 charactor")
	@Column(name="user_name",nullable = false, length =  100)
	private String userName;
	
	@NotNull
	@Column(name="password", nullable = false, length = 15)
	private String password;
	
	@NotNull
	@Email
  	private String email;
	
	@NotNull
 	private String about;
	 
	@OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL,fetch = FetchType.LAZY )
	private Set<Post> post = new HashSet<>();
	
	public UserEntity() {
		super();
	}

	public UserEntity(int userId,
			@NotNull @Size(min = 4, message = "user name must be minimum 3 charactor") String userName,
			@NotNull String password, @NotNull @Email String email, @NotNull String about, Set<Post> post) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.about = about;
		this.post = post;
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
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Set<Post> getPost() {
		return post;
	}

	public void setPost(Set<Post> post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", about=" + about + ", post=" + post + "]";
	}
 
}
