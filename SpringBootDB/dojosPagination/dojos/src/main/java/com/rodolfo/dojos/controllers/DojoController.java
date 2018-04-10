package com.rodolfo.dojos.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rodolfo.dojos.models.Dojo;
import com.rodolfo.dojos.models.Ninja;
import com.rodolfo.dojos.services.NinjaService;
import com.rodolfo.dojos.services.DojoService;

@Controller
public class DojoController {
	
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	 public DojoController(DojoService dojoService, NinjaService ninjaService){
	     this.dojoService = dojoService;
	     this.ninjaService = ninjaService;
	 }
	 
	 @RequestMapping("/")
	 public String index() {
		 return "redirect:/dojos/new";
	 }
	 
	 @RequestMapping("/dojos/new")
	 public String newPerson(@ModelAttribute("dojo") Dojo dojo) {
	     return "dojoNew.jsp";
	 }
	 
	 @PostMapping("/dojos/new")
	 public String createPerson(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
	     if (result.hasErrors()) {
	         return "dojoNew.jsp";
	     }else{
	         dojoService.addDojo(dojo);
	         return "redirect:/dojos/new";
	     }
	 }
	 
	 @RequestMapping("/dojos/{id}")
	 public String findDojosById(Model model, @PathVariable("id") long id) {
		 Dojo dojo = new Dojo();
		 dojo = dojoService.findDojoById(id);
//		 System.out.println("id " + id );
//		 System.out.println("dojoName " + dojo.getName() );
		 model.addAttribute("dojo", dojo);
	     return "dojoList.jsp";
	 }
	 
	 @RequestMapping("/dojos/pages/{pageNumber}")
	 public String getDojoPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
	     // we have to subtract 1 because the Pages iterable is 0 indexed. This is for our links to be able to show from 1...pageMax, instead of 0...pageMax class="keyword operator from-rainbow">- 1.
	     Page<Object> dojos = dojoService.dojosPerPage(pageNumber - 1);
	     // total number of pages that we have
	     int totalPages = dojos.getTotalPages();
	     model.addAttribute("totalPages", totalPages);
	     model.addAttribute("dojos", dojos);
	     return "dojos.jsp";
	 }
	 
}
