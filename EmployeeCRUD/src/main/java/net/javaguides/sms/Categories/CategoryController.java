package net.javaguides.sms.Categories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	// create
	@PostMapping("/")
	public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO){
		CategoryDTO createCategory = this.categoryService.createCategory(categoryDTO);
		return new ResponseEntity<CategoryDTO>(createCategory,HttpStatus.CREATED);
	}
	
	// update
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable("categoryId") Integer catId){
		CategoryDTO updateCategory  =this.categoryService.updateCategory(categoryDTO, catId);
		return new ResponseEntity<CategoryDTO>(updateCategory,HttpStatus.OK);
	}
	
	// delete
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
		this.categoryService.deleteCategory(catId);
		return new ResponseEntity<>(new ApiResponse("category is deleted successfully"),HttpStatus.OK);
	}
	
	// get
	
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDTO> getCategory(@Valid @PathVariable Integer catId){
		CategoryDTO categoryDTO = this.categoryService.getCategory(catId);
		return new ResponseEntity<CategoryDTO>(categoryDTO,HttpStatus.OK);
	}
	
	// get All 
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDTO>> getAllCategory(){
		List<CategoryDTO> categories = this.categoryService.getAllCategory();
		return ResponseEntity.ok(categories);
	}
}
