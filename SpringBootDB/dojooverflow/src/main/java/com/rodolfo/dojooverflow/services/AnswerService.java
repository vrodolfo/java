package com.rodolfo.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rodolfo.dojooverflow.models.Answer;
import com.rodolfo.dojooverflow.repositories.AnswerRepository;


@Service
public class AnswerService {
	
	private AnswerRepository answerRepository;

	public AnswerService(AnswerRepository answerRepository){
        this.answerRepository = answerRepository;
    }
	

	public List<Answer> allAnswers() {
	     return (List<Answer>) answerRepository.findAll();
	 }
	
	public void addAnswer(Answer answer) {
		answerRepository.save(answer);
	 }
	
	public Answer findAnswerById(Long id) {
		 return answerRepository.findById(id).orElse(null);
	}
	
	
	
}
