package com.rodolfo.dojos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rodolfo.dojos.models.Dojo;
import com.rodolfo.dojos.models.Ninja;
import com.rodolfo.dojos.services.DojoService;
import com.rodolfo.dojos.services.NinjaService;

@Controller
public class NinjaController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	 public NinjaController(DojoService dojoService, NinjaService ninjaService){
	     this.dojoService = dojoService;
	     this.ninjaService = ninjaService;
	 }
	 
	 
	 @RequestMapping("/ninjas/new")
	 public String newLicense(Model model, @ModelAttribute("ninja") Ninja ninja) {
		 List<Dojo> dojos = dojoService.allDojos();
	     model.addAttribute("dojos", dojos);
	     return "ninjaNew.jsp";
	 }
	 
	 @PostMapping("/ninjas/new")
	 public String createLicense(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, @RequestParam(value="dojo") long dojoID) {
	     if (result.hasErrors()) {
	         return "ninjaNew.jsp";
	     }else{
	    	 Dojo dojo = new Dojo();
	    	 dojo = dojoService.findDojoById(dojoID);
	    	 ninja.setDojo(dojo);
	         ninjaService.addNinja(ninja);
	         return "redirect:/ninjas/new";
	     }
	 }

}
