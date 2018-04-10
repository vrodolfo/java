package com.rodolfo.selfjoin.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rodolfo.selfjoin.models.Employee;
import com.rodolfo.selfjoin.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
	
	
	
	public List<Employee> allEmployees() {
	     return (List<Employee>) employeeRepository.findAll();
	 }
	
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	 }
	
	public Employee findEmployeeById(Long id) {
		 //System.out.println("id:::::::::::::::::" + id);
		 return employeeRepository.findById(id).orElse(null);
	}
}
