package net.javaguides.sms.post;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.sms.Categories.CategoryEntity;
import net.javaguides.sms.Categories.CategoryRepository;
import net.javaguides.sms.Exception.ResourceNotFoundException;
import net.javaguides.sms.User.UserEntity;
import net.javaguides.sms.User.UserRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public PostDto createPost(PostDto postDto , Integer userId, Integer categoryId ) {
		
		UserEntity user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User  user id : " + userId + " not found"));
		
		CategoryEntity categoryEntity = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category category id " + categoryId + " not found"));
		Post post = this.modelMapper.map(postDto, Post.class);
		
		post.setImageName("default.png");
		post.setDate( new Date());
		
		post.setUserEntity(user);
		post.setCategoryEntity(categoryEntity);
		Post newPost = this.postRepository.save(post);
 		return  this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
//		CategoryEntity cat = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Categor id : " + categoryId + " is not found "));
//		
//		List<Post> posts = this.postRepository.findByCategoryEntity(cat);
//		
		
 		return null;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
