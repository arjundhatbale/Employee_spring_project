package net.javaguides.sms.post;

import java.util.Date;

import net.javaguides.sms.Categories.CategoryDTO;
import net.javaguides.sms.Categories.CategoryEntity;
import net.javaguides.sms.User.UserDto;
import net.javaguides.sms.User.UserEntity;

public class PostDto {

	private String postTitle;
	
	private String content;

	private String imageName;
	
	private Date date;
	
	private CategoryEntity categoryDto;
	
	private UserDto userDto;

	private UserDto userEntity;

	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostDto(String postTitle, String content, String imageName, Date date, CategoryEntity categoryDto,
			UserDto userDto, UserDto userEntity) {
		super();
		this.postTitle = postTitle;
		this.content = content;
		this.imageName = imageName;
		this.date = date;
		this.categoryDto = categoryDto;
		this.userDto = userDto;
		this.userEntity = userEntity;
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

	public CategoryEntity getCategoryDto() {
		return categoryDto;
	}

	public void setCategoryDto(CategoryEntity categoryDto) {
		this.categoryDto = categoryDto;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public UserDto getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserDto userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public String toString() {
		return "PostDto [postTitle=" + postTitle + ", content=" + content + ", imageName=" + imageName + ", date="
				+ date + ", categoryDto=" + categoryDto + ", userDto=" + userDto + ", userEntity=" + userEntity + "]";
	}
 
	
	
}
