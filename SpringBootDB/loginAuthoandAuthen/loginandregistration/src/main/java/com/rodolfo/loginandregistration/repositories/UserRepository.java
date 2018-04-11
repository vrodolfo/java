package com.rodolfo.loginandregistration.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rodolfo.loginandregistration.models.User;

//imports removed for brevity
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
	
	User findByEmail(String email);
	
	@Query(value="SELECT count(*) FROM auth.roles a INNER JOIN auth.users_roles b on a.id = b.role_id WHERE a.name = 'ROLE_ADMIN' ", nativeQuery = true)
	int countAdmin();
	
	@Query(value="SELECT a.name FROM auth.roles a INNER JOIN auth.users_roles b on a.id = b.role_id INNER JOIN auth.users c on c.id  = b.user_id WHERE c.id = :id ", nativeQuery = true)
	String checkIfAdmin(@Param("id") long id);


}

