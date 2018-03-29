package com.rodolfo.thecode.controllers;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	@RequestMapping("/")
    public String index(Model model, HttpSession session, @ModelAttribute("errors") String errors) {
		
		System.out.println("errors " + errors);
		model.addAttribute("errors", errors);
        return "index.jsp";
    }
	
	@RequestMapping("/code")
    public String code(Model model, HttpSession session, @ModelAttribute("errors") String errors) {
		model.addAttribute("errors", errors);
        return "code.jsp";
    }
	
	@RequestMapping("/check")
    public String date(RedirectAttributes redirectAttributes, Model model, @RequestParam(value="code") String code) {

		if(code.equals("bushido")) {
			return "redirect:/code";
		}
		else {
			redirectAttributes.addFlashAttribute("errors", "You Must Train Harder!");
			return "redirect:/";
		}
		
	
    }
	

}

