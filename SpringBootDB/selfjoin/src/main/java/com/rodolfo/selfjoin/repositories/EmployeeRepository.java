package com.rodolfo.selfjoin.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rodolfo.selfjoin.models.Employee;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
