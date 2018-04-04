package com.rodolfo.relationships.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rodolfo.relationships.models.Person;



	@Repository
	public interface PersonRepository  extends CrudRepository<Person, Long> {
		
//		@Query(value="SELECT * FROM song ORDER BY rating DESC LIMIT 10", nativeQuery = true)
//		List<Song> topTen();
//		
    	List<Person> findAll();    
//		
//		@Query(value="SELECT * FROM song WHERE artist= :artist ORDER BY rating DESC LIMIT 10", nativeQuery = true)
//		List<Song> searchByArtist(@Param("artist") String artist);
//		
//	    Long countByTitleContaining(String search);
	}
