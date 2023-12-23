package net.javaguides.sms.post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.sms.Categories.CategoryEntity;
import net.javaguides.sms.User.UserEntity;

public interface PostRepository extends JpaRepository<Post, Integer>{


	List<Post> findByUserEntity(UserEntity userEntity);
	
	List<CategoryEntity> findByCategoryEntity(CategoryEntity categoryEntity);

}
