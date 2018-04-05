package com.rodolfo.products.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rodolfo.products.models.Product;
import com.rodolfo.products.models.Category;
import com.rodolfo.products.repositories.ProductRepository;

@Service
public class ProductService {
	private ProductRepository productRepository;
	
	
	public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
	
	
	
	public List<Product> allProducts() {
	     return (List<Product>) productRepository.findAll();
	 }
	
	public List<Product> getProductNotUsed2(long categoryID) {
		List<Product> products = productRepository.getProductsNotUsed(categoryID);
	     return products;
	 }
	
	
	public void addProduct(Product category) {
		productRepository.save(category);
	 }
	
	public Product findProductById(Long id) {
		 //System.out.println("id:::::::::::::::::" + id);
		 return productRepository.findById(id).orElse(null);
	}

}
