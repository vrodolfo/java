package com.rodolfo.dojooverflow.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rodolfo.dojooverflow.models.Tag;

public interface TagRepository  extends CrudRepository<Tag, Long>  {
	
	@Query(value="SELECT * FROM tags where subject = :desc ", nativeQuery = true)
	Tag findByTagName(@Param("desc") String desc);

}
