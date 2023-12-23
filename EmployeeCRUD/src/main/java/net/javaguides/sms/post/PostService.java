package net.javaguides.sms.post;

import java.util.List;

import jakarta.persistence.criteria.CriteriaBuilder.In;

 
public interface PostService {
	
	// create
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	// update 
	
	Post updatePost(PostDto postDto, Integer postId);
	
	// delete
	
	void deletePost(Integer postId); 
	
	// get All posts 
	
	List<Post> getAllPost();
	
	// get post by id 
	
	Post getPostById(Integer postId);
	
	// get all post by category 
	
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	// get all post by user 
	
	List<PostDto> getPostByUser(Integer userId);
	
	// search posts
	List<Post> searchPosts(String keyword);
}
