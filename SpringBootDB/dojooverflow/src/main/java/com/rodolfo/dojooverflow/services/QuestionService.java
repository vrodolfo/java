package com.rodolfo.dojooverflow.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.rodolfo.dojooverflow.models.Question;
import com.rodolfo.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	private QuestionRepository questionRepository;
	
	
	public QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }
	

	public List<Question> allQuestions() {
	     return (List<Question>) questionRepository.findAll();
	 }
	
	public void addQuestion(Question question) {
		questionRepository.save(question);
	 }
	
	public Question findQuestionById(Long id) {
		 return questionRepository.findById(id).orElse(null);
	}

}

