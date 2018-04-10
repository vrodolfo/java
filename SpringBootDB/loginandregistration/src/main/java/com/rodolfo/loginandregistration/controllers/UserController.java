package com.rodolfo.loginandregistration.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rodolfo.loginandregistration.models.User;
import com.rodolfo.loginandregistration.services.UserService;

@Controller
public class UserController {
    
	private UserService userService;
	
	public UserController(UserService userService) {
        this.userService = userService;
    }
	
	 @RequestMapping("/dashboard")
	    public String results(Principal principal, Model model) {
		 String username = principal.getName();
	     model.addAttribute("currentUser", userService.findByEmail(username));
	     return "dashboard.jsp";
	    }
	 
	@RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        // 1
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByEmail(username));
        return "dashboard.jsp";
    }
	
	@PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            return "registrationPage.jsp";
        }
        userService.saveWithUserRole(user);
        return "redirect:/login";
    }
	
    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    
//    @RequestMapping("/login")
//    public String login(@Valid @ModelAttribute("user") User user) {
//        return "registrationPage.jsp";
//    }
    @RequestMapping("/login")
    public String login(@Valid @ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "registrationPage.jsp";
    }
    
   
}
