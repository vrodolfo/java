package com.rodolfo.counter.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
    public String index(Model model, HttpSession session) {
		int counter = 1;

		if (session.getAttribute("counter") != null) {
			counter = (int) session.getAttribute("counter");
			counter ++;
		}
		session.setAttribute("counter", counter);
		
        return "index.jsp";
    }
	
	@RequestMapping("/counter")
    public String date(Model model, HttpSession session) {
		int counter = 0;
		if (session.getAttribute("counter") != null) {
			counter = (int) session.getAttribute("counter");
		}
		model.addAttribute("counter", counter);
        return "counter.jsp";
    }

}
