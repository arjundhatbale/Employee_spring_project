package net.javaguides.sms.Categories;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class CategoryDTO {

	 
	 
 	
	@Nullable
	@Size(min = 4, max =  20, message = "size of tile between 4 and 20 Charactors")
  	private String categorytitle;
	@Size(min = 4, max =  20, message = "size of Description between 4 and 20 Charactors")
 	private String categoryDescription;
	
	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryDTO(  String categorytitle, String categoryDescription) {
		super();
 		this.categorytitle = categorytitle;
		this.categoryDescription = categoryDescription;
	}

	 

	public String getCategorytitle() {
		return categorytitle;
	}

	public void setCategorytitle(String categorytitle) {
		this.categorytitle = categorytitle;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	@Override
	public String toString() {
		return "CategoryDTO [  categorytitle=" + categorytitle + ", categoryDescription="
				+ categoryDescription + "]";
	}

	 
	 
	
}
