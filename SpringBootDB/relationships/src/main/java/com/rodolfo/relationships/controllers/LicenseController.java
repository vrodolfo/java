package com.rodolfo.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rodolfo.relationships.models.License;
import com.rodolfo.relationships.models.Person;
import com.rodolfo.relationships.services.LicenseService;
import com.rodolfo.relationships.services.PersonService;

@Controller
public class LicenseController {
	private final PersonService personService;
	private final LicenseService licenseService;
	 public LicenseController(PersonService personService, LicenseService licenseService){
	     this.personService = personService;
	     this.licenseService = licenseService;
	 }
	 
	 
	 @RequestMapping("/licenses/new")
	 public String newLicense(Model model, @ModelAttribute("license") License license) {
		 List<Person> people = personService.allPeople();
	     model.addAttribute("people", people);
	     return "licenseNew.jsp";
	 }
	 
	 @PostMapping("/licenses/new")
	 public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result, @RequestParam(value="person") long personID) {
	     if (result.hasErrors()) {
	         return "licenseNew.jsp";
	     }else{
	    	 Person person = new Person();
	    	 person = personService.findPersonById(personID);
	    	 license.setPerson(person);
	    	 String number = licenseService.getNumber();
	    	 license.setNumber(number);
	         licenseService.addLicense(license);
	         return "redirect:/licenses/new";
	     }
	 }

}
