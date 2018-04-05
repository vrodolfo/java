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
	public class CategoryController {
		private final ProductService productService;
		private final CategoryService categoryService;
		 public CategoryController(ProductService productService, CategoryService categoryService){
		// public CategoryController(CategoryService categoryService){
		     this.productService = productService;
		     this.categoryService = categoryService;
		 }
		 
		 
		 @RequestMapping("/categories/new")
		 public String newCategory(Model model, @ModelAttribute("category") Product category) {
			// List<Category> categories = categoryService.allCategories();
		    // model.addAttribute("categories", categories);
		     return "categoryNew.jsp";
		 }
		 
		 @PostMapping("/categories/new")
		 public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		     if (result.hasErrors()) {
		         return "categoryNew.jsp";
		     }else{
		    	//Product product = new Product();
		    	//product = productService.findProductById(prodID);
		    	// category.setProducts(product);
		         categoryService.addCategory(category);
		         return "redirect:/categories/new";
		     }
		 }
		 
		 
		 @PostMapping("/categories/{id}/addProduct")
		 public String addProduct(Model model, @PathVariable("id") long id, @RequestParam(value="productID") long productID) {
			 Product product = productService.findProductById(productID);
			 Category category = categoryService.findCategoryById(id);
			 category.setProducts(product);
			 categoryService.addCategory(category);
		     return ("redirect:/categories/" + id);
		     
		 }
		 
		 @RequestMapping("/categories/{id}")
		 public String findCategoryById(Model model, @PathVariable("id") long id) {
			 Category category = new Category();
			 category = categoryService.findCategoryById(id);
			 List<Product> products = productService.getProductNotUsed2(id);
			 model.addAttribute("products", products);
			 model.addAttribute("category", category);
		     return "categoryAddProduct.jsp";
		 }

	}

