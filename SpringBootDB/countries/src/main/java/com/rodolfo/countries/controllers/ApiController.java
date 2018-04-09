package com.rodolfo.countries.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rodolfo.countries.models.Country;
import com.rodolfo.countries.models.Language;
import com.rodolfo.countries.services.ApiService;


@Controller
public class ApiController {
	private final ApiService apiService;
	
	
	public ApiController(ApiService apiService){
	     this.apiService = apiService;
	 }
	
	
	@RequestMapping("/")
	 public String index(Model model) {
		List<Object[]> result1 = apiService.query1();
		List<Object[]> result2 = apiService.query2();
		List<Object[]> result3 = apiService.query3();
		List<Object[]> result4 = apiService.query4();
		List<Object[]> result5 = apiService.query5();
		List<Object[]> result6 = apiService.query6();
		List<Object[]> result7 = apiService.query7();
		List<Object[]> result8 = apiService.query8();
//		Language language = new Language();
//	    Country country = new Country();
//		for(Object[] row : result1) {
//		    //language = (Language) row[1];
//		    //country = (Country) row[0];
//		    System.out.println(row[0]);
//		    //System.out.println(ninja.getFirstName());
//		}
		//System.out.println(result1[0]);
	    model.addAttribute("result1", result1);
	    model.addAttribute("result2", result2);
	    model.addAttribute("result3", result3);
	    model.addAttribute("result4", result4);
	    model.addAttribute("result5", result5);
	    model.addAttribute("result6", result6);
	    model.addAttribute("result7", result7);
	    model.addAttribute("result8", result8);
	    //model.addAttribute("country", country);
	    return "index.jsp";
	 }

}
