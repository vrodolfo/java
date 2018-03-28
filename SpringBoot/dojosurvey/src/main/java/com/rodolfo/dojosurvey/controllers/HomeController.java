package com.rodolfo.dojosurvey.controllers;

import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
    public String index() {
		
        return "index.jsp";
    }
	
	@RequestMapping(path="/survey/add", method=RequestMethod.POST)
    public String index(Model model, HttpSession session, @RequestParam(value="name") String name, @RequestParam(value="dojo") String dojo, @RequestParam(value="language") String language, @RequestParam(value="comment") String comment) {

		
		session.setAttribute("name", name);
		session.setAttribute("dojo", dojo);
		session.setAttribute("language", language);
		session.setAttribute("comment", comment);
		
        return "redirect:/result";
    }
	
	@RequestMapping("/result")
    public String index(Model model, HttpSession session) {

		model.addAttribute("name", session.getAttribute("name"));
		model.addAttribute("dojo", session.getAttribute("dojo"));
		model.addAttribute("language", session.getAttribute("language"));
		model.addAttribute("comment", session.getAttribute("comment"));
		
        return "results.jsp";
    }
	

}


