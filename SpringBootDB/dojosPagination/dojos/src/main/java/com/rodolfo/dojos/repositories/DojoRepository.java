package com.rodolfo.dojos.repositories;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.rodolfo.dojos.models.Dojo;


@Repository
public interface DojoRepository  extends PagingAndSortingRepository<Dojo, Long> {
	
	@Query(value="select d.name, n.first_name, n.last_name from dojos.dojos d inner join dojos.ninjas n on d.id = n.dojo_id ORDER BY ?#{#pageable} ", countQuery = "SELECT count(*) FROM dojos.dojos d inner join dojos.ninjas n on d.id = n.dojo_id", nativeQuery = true)
	Page<Object> allDojos(Pageable pageable);

}
