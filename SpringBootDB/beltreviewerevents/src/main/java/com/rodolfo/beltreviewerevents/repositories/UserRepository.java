package com.rodolfo.beltreviewerevents.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rodolfo.beltreviewerevents.models.User;

@Repository
public interface UserRepository  extends CrudRepository<User, Long> {
	List<User> findAll();
	
	User findByEmail(String email);
	
	@Query(value="SELECT count(*) FROM roles a INNER JOIN users_roles b on a.id = b.role_id WHERE a.name = 'ROLE_ADMIN' ", nativeQuery = true)
	int countAdmin();
	
	@Query(value="SELECT a.name FROM roles a INNER JOIN users_roles b on a.id = b.role_id INNER JOIN users c on c.id  = b.user_id WHERE c.id = :id ", nativeQuery = true)
	String checkIfAdmin(@Param("id") long id);


}
