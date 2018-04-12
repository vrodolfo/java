package com.rodolfo.beltreviewerevents.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rodolfo.beltreviewerevents.models.Event;

@Repository
public interface EventRepository  extends CrudRepository<Event, Long> {

	
	@Query(value="SELECT * FROM events  WHERE state = :state ", nativeQuery = true)
	List<Event> findInState(@Param("state") String state);
	
	@Query(value="SELECT * FROM events  WHERE state != :state ", nativeQuery = true)
	List<Event> findOutState(@Param("state") String state);
}
