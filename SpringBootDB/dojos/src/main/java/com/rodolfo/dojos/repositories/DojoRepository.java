package com.rodolfo.dojos.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.rodolfo.dojos.models.Dojo;


@Repository
public interface DojoRepository  extends CrudRepository<Dojo, Long> {
	
//	@Query(value="SELECT * FROM song ORDER BY rating DESC LIMIT 10", nativeQuery = true)
//	List<License> topTen();
//	
//	List<Song> findAll();    
//	
//	@Query(value="SELECT IFNULL(id+1, 1) FROM licenses ORDER BY id DESC LIMIT 0, 1", nativeQuery = true)
//	long getLastId();
//	
//    Long countByTitleContaining(String search);
}
