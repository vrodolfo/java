package com.rodolfo.beltreviewerevents.controllers;


import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rodolfo.beltreviewerevents.models.Event;
import com.rodolfo.beltreviewerevents.models.Message;
import com.rodolfo.beltreviewerevents.models.User;
import com.rodolfo.beltreviewerevents.services.UserService;
import com.rodolfo.beltreviewerevents.services.EventService;
import com.rodolfo.beltreviewerevents.services.MessageService;

@Controller
public class UserController {
    
	private UserService userService;
	private EventService eventService;
	private MessageService messageService;
	
	public UserController(UserService userService, EventService eventService, MessageService messageService) {
        this.userService = userService;
        this.eventService = eventService;
        this.messageService = messageService;
    }
	
	 @RequestMapping("/dashboard")
	    public String results(Principal principal, Model model, @ModelAttribute("event") Event event) {
		 String username = principal.getName();
		 User currentuser = userService.findByEmail(username);
		 currentuser.setState("TX");
		 userService.updateUser(currentuser);
	     String state = currentuser.getState();
	     
	     List<Event> eventsInState = eventService.findEventsByState(state);
	     List<Event> eventsOutState = eventService.findEventsByNotState(state);
	     model.addAttribute("eventsInState", eventsInState);
	     model.addAttribute("eventsOutState", eventsOutState);
	     model.addAttribute("currentUser", currentuser);

	     return "dashboard.jsp";

	 }
	 
	 @RequestMapping("/events/{id}/delete")
	    public String deleteEvent(@PathVariable long id) {
	    	eventService.deleteEvent(id);
	        return "redirect:/dashboard";
	 }
	 
	 
	 @PostMapping("/events/new")
	 public String createPerson(Principal principal, @Valid @ModelAttribute("event") Event event, BindingResult result) {
	     if (result.hasErrors()) {
	         return "dashboard.jsp";
	     }else{
	    	 String username = principal.getName();
			 User currentuser = userService.findByEmail(username);
	    	 event.setHost(currentuser);
	         eventService.addEvent(event);
	         return "redirect:/dashboard";
	     }
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
        //check if any admin
        if(userService.checkAdmin() == 0) {
        	userService.saveUserWithAdminRole(user);
        }
        else {
        	userService.saveWithUserRole(user);
        }
        
        return "redirect:/login";
    }
	
    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    
    @RequestMapping("/users/{id}/delete")
    public String delete(@PathVariable long id) {
    	userService.deleteUser(id);
        return "redirect:/dashboard";
    }
    
    @RequestMapping("/users/{id}/makeadmin")
    public String admin(@PathVariable long id) {
    	userService.makeadmin(id);
        return "redirect:/dashboard";
    }
    
    
    

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
    
    @RequestMapping("/events/{id}/join")
    public String joinEvent(Principal principal, @PathVariable long id) {
    	String username = principal.getName();
		User currentuser = userService.findByEmail(username);
		
		Event event = eventService.findEventById(id);
		event.addAttendee(currentuser);
    	eventService.addEvent(event);
        return "redirect:/dashboard";
    }
    
    @RequestMapping("/events/{id}/cancel")
    public String cancelEvent(Principal principal, @PathVariable long id) {
    	String username = principal.getName();
		User currentuser = userService.findByEmail(username);
		
		Event event = eventService.findEventById(id);
		event.cancelJoin(currentuser);
    	eventService.addEvent(event);
        return "redirect:/dashboard";
    }
    
    @RequestMapping("/events/{id}/edit")
    public String eventEdit(Principal principal, @PathVariable long id, Model model, @ModelAttribute("event") Event event) {
    	String username = principal.getName();
		User currentuser = userService.findByEmail(username);
		
		event = eventService.findEventById(id);
		model.addAttribute("event", event);
		
        return "eventEdit.jsp";
    }
    
    @PostMapping("/events/{id}/edit")
    public String updateEvent(Principal principal, @Valid @ModelAttribute("event") Event event, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            return "eventEdit.jsp";
        }
        
        String username = principal.getName();
		User currentuser = userService.findByEmail(username);
   	    event.setHost(currentuser);
        
        eventService.addEvent(event);
        
        return "redirect:/dashboard";
    }
    
    @RequestMapping("/events/{id}")
    public String showEvent(Principal principal, @PathVariable long id, Model model, @ModelAttribute("message") Message message) {
    	Event event = eventService.findEventById(id);
    	List<Message> messages = messageService.findAll2();
    	model.addAttribute("messages", messages);
    	model.addAttribute("event", event);
        return "eventShow.jsp";
    }
    
    @PostMapping("/events/{id}/messages/add")
    public String addMessage(Principal principal, @Valid @ModelAttribute("message") Message message, BindingResult result, Model model, HttpSession session, @PathVariable long id) {
        if (result.hasErrors()) {
            return "eventShow.jsp";
        }
        Event event = eventService.findEventById(id);
        String username = principal.getName();
		User currentuser = userService.findByEmail(username);
   	    message.setUser(currentuser);
   	    event.addMessage(message);
   	    messageService.addMessage(message);
        eventService.addEvent(event);
        
        return ("redirect:/events/" + id);
    }
    
   
}
