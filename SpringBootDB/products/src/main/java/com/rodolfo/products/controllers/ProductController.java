package com.rodolfo.products.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rodolfo.products.models.Product;
import com.rodolfo.products.models.Category;
import com.rodolfo.products.services.ProductService;
import com.rodolfo.products.services.CategoryService;

@Controller
public class ProductController {
	private final ProductService productService;
	private final CategoryService categoryService;
	 public ProductController(ProductService productService, CategoryService categoryService){
	     this.productService = productService;
	     this.categoryService = categoryService;
	 }
	 
	 
	 @RequestMapping("/products/new")
	 public String newProduct(Model model, @ModelAttribute("product") Product product) {
		 List<Category> categories = categoryService.allCategories();
	     model.addAttribute("categories", categories);
	     return "productNew.jsp";
	 }
	 
	 @PostMapping("/products/new")
	 public String createLicense(@Valid @ModelAttribute("product") Product product, BindingResult result) {
	     if (result.hasErrors()) {
	         return "productNew.jsp";
	     }else{
	         productService.addProduct(product);
	         return "redirect:/products/new";
	     }
	 }
	 
	 @PostMapping("/products/{id}/addCategory")
	 public String addCategory(Model model, @PathVariable("id") long id, @RequestParam(value="category") long idCategory) {
		 Product product = productService.findProductById(id);
		 Category category = categoryService.findCategoryById(idCategory);
		 product.setCategories(category);
		 productService.addProduct(product);
	     return ("redirect:/products/" + id);
	     
	 }
	 
	 @RequestMapping("/products/{id}")
	 public String findProductsById(Model model, @PathVariable("id") long id) {
		 Product product = new Product();
		 product = productService.findProductById(id);
		 List<Category> categories = categoryService.getCategoriesNotUsed2(id);
		 model.addAttribute("categories", categories);
		 model.addAttribute("product", product);
	     return "productAddCategory.jsp";
	 }

}
