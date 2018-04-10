package com.rodolfo.loginandregistration.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rodolfo.loginandregistration.models.User;

//imports removed for brevity
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
}

