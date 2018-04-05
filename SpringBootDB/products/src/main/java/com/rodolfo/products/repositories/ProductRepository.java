package com.rodolfo.products.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.rodolfo.products.models.Product;
import com.rodolfo.products.models.Category;


@Repository
public interface ProductRepository  extends CrudRepository<Product, Long> {
	
//	@Query(value="SELECT * FROM song ORDER BY rating DESC LIMIT 10", nativeQuery = true)
//	List<License> topTen();
//	
//	List<Song> findAll();    
//	
	@Query(value="SELECT * FROM products where id not in (SELECT product_id from categories_products where category_id = :categoryID  )", nativeQuery = true)
	List<Product> getProductsNotUsed(@Param("categoryID") long categoryID);
//	
//    Long countByTitleContaining(String search);
}

