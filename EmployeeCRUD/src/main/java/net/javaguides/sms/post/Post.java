package net.javaguides.sms.post;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import net.javaguides.sms.Categories.CategoryEntity;
import net.javaguides.sms.User.UserEntity;

@Entity
@Table(name="post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="post_Id")
	private Integer postId;
	
	@Nullable
	@Column(name="post_title",nullable = false,length = 100)
	private String postTitle;
	
	@Size(min=4 ,message = "size of content minimum 4 charactors,")
	private String content;
	
	private String imageName;
	
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
  	private CategoryEntity categoryEntity;
 	
 	@ManyToOne
 	@JoinColumn(name="user_Id")
 	private UserEntity userEntity;

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(Integer postId, String postTitle,
			@Size(min = 4, message = "size of content minimum 4 charactors,") String content, String imageName,
			Date date, CategoryEntity categoryEntity, UserEntity userEntity) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.content = content;
		this.imageName = imageName;
		this.date = date;
		this.categoryEntity = categoryEntity;
		this.userEntity = userEntity;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postTitle=" + postTitle + ", content=" + content + ", imageName="
				+ imageName + ", date=" + date + ", categoryEntity=" + categoryEntity + ", userEntity=" + userEntity
				+ "]";
	}

	 
 	
}
