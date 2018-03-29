package com.rodolfo.learningplatform.controllers;
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

@Controller
public class HomeController {
	@RequestMapping("/")
    public String index(Model model, HttpSession session) {
		
        return "fortran.jsp";
    }
	
	@RequestMapping("/m/{chapter}/{typeAss}/{assignmentNumber}")
    public String date(Model model, @PathVariable String chapter, @PathVariable String typeAss, @PathVariable String assignmentNumber) {
		//lesson
		String content = "";
		
		if(typeAss.equals("0553")) {
			if(assignmentNumber.equals("0733")) {
				content = "Setting up your servers";
			}
			else if(assignmentNumber.equals("0342")) {
				content = "Punch Cards";
			}
			else if(assignmentNumber.equals("0348")) {
				content = "Advanced Fortran Intro";
			}	
			
			System.out.println("content " + content);
			model.addAttribute("content", content);
			return "lesson.jsp";
			
		}
		
		//assignment
		else if(typeAss.equals("0483")) {
			if(assignmentNumber.equals("0345")) {
				content = "Coding Forms";
			}
			else if(assignmentNumber.equals("2342")) {
				content = "Fortran to Binary";
			}	
			
			model.addAttribute("content", content);
			return "assignment.jsp";		
		}
		
		else {
			return "redirect:/";
		}
	
    }
	

}
