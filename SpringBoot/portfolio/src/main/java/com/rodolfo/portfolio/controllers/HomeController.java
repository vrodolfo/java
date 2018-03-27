package com.rodolfo.portfolio.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	@RequestMapping("/")
    public String index() {
		return "forward:/index.html";
    }
	
	@RequestMapping("/projects")
    public String projects() {
		return "forward:/projects.html";
    }
	
	@RequestMapping("/me")
    public String about() {
		return "forward:/about.html";
    }
}
