package net.javaguides.sms.Categories;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import net.javaguides.sms.Exception.ResourceNotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDTO getCategory(Integer categoryId) {
 		CategoryEntity cat = this.categoryRepository.findById(categoryId)
 				.orElseThrow(()-> new ResourceNotFoundException("Category  with id : " + categoryId + " is not found"));
 		
		
		return  this.modelMapper.map(cat, CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getAllCategory() {
		List<CategoryEntity>listofCategory =	this.categoryRepository.findAll();
		
	    List<CategoryDTO> catDtos	= listofCategory.stream().map( (cat) -> this.modelMapper.map(cat,CategoryDTO.class)).collect(Collectors.toList());
		
 		return   catDtos;
	}

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		// TODO Auto-generated method stub
		CategoryEntity entity = this.modelMapper.map(categoryDTO,  CategoryEntity.class);
		CategoryEntity addedentity = 	this.categoryRepository.save(entity);
		return  this.modelMapper.map(addedentity, CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId) {
		CategoryEntity category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category with : " + categoryId + " this id not found"));
		category.setCategorytitle(categoryDTO.getCategorytitle());
		category.setCategoryDescription(categoryDTO.getCategoryDescription());
		
		CategoryEntity updatedCategoryEntity = this.categoryRepository.save(category);
 		return this.modelMapper.map(updatedCategoryEntity, CategoryDTO.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
 		CategoryEntity cat = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category" + "category Id " + categoryId));
 		this.categoryRepository.delete(cat);
 		
	}

	 
	
	
	
}
