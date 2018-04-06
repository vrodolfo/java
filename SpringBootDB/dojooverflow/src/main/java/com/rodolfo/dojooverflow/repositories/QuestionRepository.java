package com.rodolfo.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rodolfo.dojooverflow.models.Question;

public interface QuestionRepository  extends CrudRepository<Question, Long>  {
	
//	@Query(value="SELECT * FROM categories where id not in (SELECT category_id from categories_products where product_id = :productID  )", nativeQuery = true)
//	List<Category> getCategoriesNotUsed(@Param("productID") long productID);

}
