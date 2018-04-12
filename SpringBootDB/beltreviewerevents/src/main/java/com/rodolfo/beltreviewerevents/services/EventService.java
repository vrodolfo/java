package com.rodolfo.beltreviewerevents.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.rodolfo.beltreviewerevents.models.Event;
import com.rodolfo.beltreviewerevents.models.User;
import com.rodolfo.beltreviewerevents.repositories.RoleRepository;
import com.rodolfo.beltreviewerevents.repositories.EventRepository;
@Service
public class EventService {
	
	
	private EventRepository eventRepository;
    
	public EventService(EventRepository eventRepository)     {
        this.eventRepository = eventRepository;
    }
	
	public List<Event> findEventsByState(String state) {    	
    	return eventRepository.findInState(state);
    }
	
	public List<Event> findEventsByNotState(String state) {    	
    	return eventRepository.findOutState(state);
    }
	
	public void addEvent(Event event) {
		eventRepository.save(event);
	 }
	
	public Event findEventById(Long id) {
		 return eventRepository.findById(id).orElse(null);
	}
	
	public void deleteEvent(long id) {    	
    	Event event = eventRepository.findById(id).orElse(null);
    	event.getUsersAttending().removeAll(event.getUsersAttending());
    	eventRepository.delete(event);
    }

}
