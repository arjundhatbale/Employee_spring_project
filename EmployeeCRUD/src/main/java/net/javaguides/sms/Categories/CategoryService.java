package net.javaguides.sms.Categories;

import java.util.List;

public  interface CategoryService {

	// get
	CategoryDTO getCategory(Integer categoryId);
 	// getAll 
	List<CategoryDTO> getAllCategory();
  	// create 
 	CategoryDTO createCategory(CategoryDTO categoryDTO);
    // update
	CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId);
  	// delete
	void deleteCategory(Integer categoryId);
 }
