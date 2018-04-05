package com.rodolfo.products.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rodolfo.products.models.Category;
import com.rodolfo.products.repositories.CategoryRepository;

@Service
public class CategoryService {
	private CategoryRepository categoryRepository;
	
	
	public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
	
	public List<Category> getCategoriesNotUsed2(long productID) {
		System.out.println("id::::::::::: " + productID);
		List<Category> categories = categoryRepository.getCategoriesNotUsed(productID);
		System.out.println("jajajajajajajaja ");
	     return categories;
	 }
	
	
	
	public List<Category> allCategories() {
	     return (List<Category>) categoryRepository.findAll();
	 }
	
	public void addCategory(Category category) {
		categoryRepository.save(category);
	 }
	
	public Category findCategoryById(Long id) {
		 //System.out.println("id:::::::::::::::::" + id);
		 return categoryRepository.findById(id).orElse(null);
	}

}
