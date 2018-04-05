package com.rodolfo.products.repositories;

	import java.util.List;

	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.CrudRepository;
	import org.springframework.data.repository.query.Param;
	import org.springframework.stereotype.Repository;
	import com.rodolfo.products.models.Category;


	@Repository
	public interface CategoryRepository  extends CrudRepository<Category, Long> {
		
//		@Query(value="SELECT * FROM song ORDER BY rating DESC LIMIT 10", nativeQuery = true)
//		List<License> topTen();
	//	
//		List<Song> findAll();    
	//	
//		@Query(value="SELECT IFNULL(id+1, 1) FROM licenses ORDER BY id DESC LIMIT 0, 1", nativeQuery = true)
//		long getLastId();
	//	
//	    Long countByTitleContaining(String search);
		
		@Query(value="SELECT * FROM categories where id not in (SELECT category_id from categories_products where product_id = :productID  )", nativeQuery = true)
		List<Category> getCategoriesNotUsed(@Param("productID") long productID);
	}

