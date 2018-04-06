package com.rodolfo.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rodolfo.dojooverflow.services.QuestionService;
import com.rodolfo.dojooverflow.services.TagService;
import com.rodolfo.dojooverflow.models.Answer;
import com.rodolfo.dojooverflow.models.Question;
import com.rodolfo.dojooverflow.models.Tag;
import com.rodolfo.dojooverflow.services.AnswerService;

@Controller
public class QuestionController {
	
	private final QuestionService questionService;
	private final TagService tagService;
	private final AnswerService answerService;
	
	public QuestionController(QuestionService questionService, TagService tagService, AnswerService answerService) {
		this.questionService = questionService;
		this.tagService = tagService ;
		this.answerService = answerService;
	}
	
	@RequestMapping("/questions/new")
	 public String newQuestion(Model model, @ModelAttribute("question") Question question) {
		
	    return "questionNew.jsp";
	 }
	
	@PostMapping("/questions/new")
	 public String createQuestion(Model model, @Valid @ModelAttribute("question") Question question, BindingResult result, @RequestParam(value="tag") String tag) {
	     if (result.hasErrors()) {
	         return "questionNew.jsp";
	     }else{
	    	 String[] tags = tag.split(",");
	    	 String errors = "";
	    	 if(tags.length > 3) {
	    		 errors = "More than 3 tags are not allowed!!!";
	    		 model.addAttribute("errors", errors);
	    		 return "questionNew.jsp";
	    	 }
	    	 
	    	 //Create the question
	    	 questionService.addQuestion(question);
	    	 Tag tag2 = new Tag();
	    	 for (int i=0 ; i < tags.length ; i++) {
	    		 
	    		 tag2 = tagService.findTagByDesc(tags[i]);
	    		 if (tag2 == null) {
	    			 tag2 = new Tag();
	    			 tag2.setSubject(tags[i]);
	    			 tagService.addTag(tag2);
	    			 
	    			 question.setTags(tag2);
		    		 questionService.addQuestion(question);
	    		 }
	    		 else {
	    			 question.setTags(tag2);
		    		 questionService.addQuestion(question);
	    		 }
	    	 }
	         return "redirect:/questions/new";
	     }
	 }
	
	
	@PostMapping("/answers/new")
	 public String createAnswer(Model model, @Valid @ModelAttribute("answer") Answer answer, BindingResult result, @RequestParam(value="questionID") Long questionID) {
	     if (result.hasErrors()) {
	         return "redirect:/questions/" + questionID;
	     }else{
	    	 Question question = new Question();
	    	 question = questionService.findQuestionById(questionID);
	    	 answer.setQuestion(question);
	    	 answerService.addAnswer(answer);
	    	 
	         return "redirect:/questions/" + questionID;
	     }
	 }
	
	
	 @RequestMapping("/questions")
	 public String findQuestions(Model model) {
		 List<Question> questions = new ArrayList<>();
		 questions = questionService.allQuestions();
		 model.addAttribute("questions", questions);
	     return "questionList.jsp";
	 }
	 
	 @RequestMapping("/questions/{id}")
	 public String findQuestionById(Model model, @PathVariable("id") long id, @ModelAttribute("answer") Answer answer) {
		 Question question = new Question();
		 question = questionService.findQuestionById(id);
		 model.addAttribute("question", question);
	     return "questionShow.jsp";
	 }
	

}
