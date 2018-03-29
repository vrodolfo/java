package com.rodolfo.ninjagold.controllers;
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
		int gold = 0;
		ArrayList<String> activities = new ArrayList();
		if(session.getAttribute("gold") != null) {
			gold = (int) session.getAttribute("gold");
			activities = (ArrayList<String>) session.getAttribute("activities");
		}
		else {
			session.setAttribute("gold", gold);
			session.setAttribute("activities", activities);
		}
		
		model.addAttribute("gold", gold);
		model.addAttribute("activities", activities);
        return "index.jsp";
    }
	
	@RequestMapping(path="/gold", method=RequestMethod.POST)
    public String date(Model model, HttpSession session, @RequestParam(value="building") String building) {
		Date date = new Date();
		ArrayList<String> activities = new ArrayList();
		String activity ="";
		int gold = (int) session.getAttribute("gold");
		activities = (ArrayList<String>) session.getAttribute("activities");
		Random rand = new Random();
		
		if(building.equals("farm")) {
			gold = gold + rand.nextInt((20 - 10) + 1) + 10;
			activity = "Farm and won " +  Integer.toString(gold) + " on " + date;
		}
		else if(building.equals("cave")) {
			gold = gold + rand.nextInt((10 - 5) + 1) + 5;
			activity = "Cave and won " +  Integer.toString(gold) + " on " + date;
			
		}
		else if(building.equals("house")) {
			gold = gold + rand.nextInt((5 - 2) + 1) + 2;
			activity = "House and won " +  Integer.toString(gold) + " on " + date;
		}
		else if(building.equals("casino")) {
			//int number = random.nextInt(max + 1 -min) + min; 
			gold =  gold + rand.nextInt(50 + 1 +50) -50;
			if(gold < 0) {
				activity = "Casino and lost " +  Integer.toString(gold) + " on " + date;
			} 
			else {
				activity = "Casino and won " +  Integer.toString(gold) + " on " + date;
			}
		}
		
		
		activities.add(activity);
		session.setAttribute("activities", activities);
		session.setAttribute("gold", gold);

		return "redirect:/";
    }
	

}
