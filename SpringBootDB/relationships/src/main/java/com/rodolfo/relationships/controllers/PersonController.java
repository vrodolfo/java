package com.rodolfo.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rodolfo.relationships.models.License;
import com.rodolfo.relationships.models.Person;
import com.rodolfo.relationships.services.PersonService;
import com.rodolfo.relationships.services.LicenseService;

@Controller
public class PersonController {
	
	private final PersonService personService;
	private final LicenseService licenseService;
	 public PersonController(PersonService personService, LicenseService licenseService){
	     this.personService = personService;
	     this.licenseService = licenseService;
	 }
	 
	 @RequestMapping("/")
	 public String index() {
		 return "redirect:/persons/new";
	 }
	 
	 @RequestMapping("/persons/new")
	 public String newPerson(@ModelAttribute("person") Person person) {
	     return "personNew.jsp";
	 }
	 
	 @PostMapping("/persons/new")
	 public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
	     if (result.hasErrors()) {
	         return "personNew.jsp";
	     }else{
	    	 System.out.println("Firstname: " + person.getFirstName());
	    	 System.out.println("Laststname: " + person.getLastName());
	         personService.addPerson(person);
	         return "redirect:/persons/new";
	     }
	 }
	 
	 @RequestMapping("/persons/{id}")
	 public String findPersonById(Model model, @PathVariable("id") long id) {
		 model.addAttribute("person", personService.findPersonById(id));
	     return "personShow.jsp";
	 }
	 
	 

}
