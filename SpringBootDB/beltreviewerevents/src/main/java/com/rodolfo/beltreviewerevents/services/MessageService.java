package com.rodolfo.beltreviewerevents.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rodolfo.beltreviewerevents.models.Message;
import com.rodolfo.beltreviewerevents.models.User;
import com.rodolfo.beltreviewerevents.repositories.MessageRepository;

@Service
public class MessageService {
	
	private MessageRepository messageRepository;
    
	public MessageService(MessageRepository messageRepository)     {
        this.messageRepository = messageRepository;
    }
	
	public void addMessage(Message message) {
		messageRepository.save(message);
	}
	
	 public List<Message> findAll2() {    	
	    	return (List<Message>) messageRepository.findAll();
	 }

}
