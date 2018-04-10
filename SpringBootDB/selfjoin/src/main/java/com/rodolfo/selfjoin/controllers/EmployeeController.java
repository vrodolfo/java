package com.rodolfo.selfjoin.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rodolfo.selfjoin.models.Employee;
import com.rodolfo.selfjoin.services.EmployeeService;

@Controller
public class EmployeeController {
	private final EmployeeService employeeService;
	 public EmployeeController(EmployeeService employeeService){
	     this.employeeService = employeeService;
	 }
	 
	 @RequestMapping("/")
	 public String index(Model model) {
//		 Employee emp1 = new Employee("Rodolfo", "Valdi");
//		 employeeService.addEmployee(emp1);
//		 
//		 Employee emp2 = new Employee("Sub1", "Valdi");
//		 Employee emp3 = new Employee("Sub2", "Valdi");
//		 Employee emp4 = new Employee("Sub3", "Valdi");
//		 Employee emp5 = new Employee("Sub4", "Valdi");
//		 
//		 
//		 emp2.setManager(emp1);
//		 emp3.setManager(emp1);
//		 emp4.setManager(emp1);
//		 emp5.setManager(emp1);
//		 
//		 employeeService.addEmployee(emp2);
//		 employeeService.addEmployee(emp3);
//		 employeeService.addEmployee(emp4);
//		 employeeService.addEmployee(emp5);
		 
		 Employee emp1 = employeeService.findEmployeeById(Long.valueOf(1));
		 List<Employee> employees = emp1.getEmployees();
		 model.addAttribute("manager", emp1);
		 model.addAttribute("employees", employees);
		 return "index.jsp";
	 }
	 
	

}
