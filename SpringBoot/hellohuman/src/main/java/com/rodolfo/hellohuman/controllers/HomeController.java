package com.rodolfo.hellohuman.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
    public String index(Model model, HttpSession session, @RequestParam(value="firstname", required=false) String firstname, @RequestParam(value="lastname", required=false) String lastname) {

		if (firstname == null) {
			firstname = "Human";
		}
		if (lastname == null) {
			lastname = "";
		}
		model.addAttribute("firstname", firstname);
		model.addAttribute("lastname", lastname);
		
        return "index.jsp";
    }
	

}

