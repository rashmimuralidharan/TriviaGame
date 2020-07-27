package com.rashmi.triviagame.Questions;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rashmi.triviagame.Users.User;

@RestController
public class QuestionsController {
	
	@Autowired
	private QuestionsService questionsService;
	
	// getAll questions, create one question, get one question
	
	@RequestMapping("/questions")
	public List<Question> getAllQuestions(){
		return questionsService.getAllQuestions();
	}
	
	@RequestMapping("/questions/{questionId}")
	public Question getQuestionById(@PathVariable String questionId) {
		return questionsService.getQuestion(questionId);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value= "/questions")
	public void addQuestion(@RequestBody Question question) {
		questionsService.addQuestion(question);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value= "/questions/{questionId}")
	public void updateQuestion(@RequestBody Question question, @PathVariable String questionId) {
		questionsService.updateQuestion(questionId, question);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value= "/questions/{questionId}")
	public void deleteQuestion(@PathVariable String questionId) {
		questionsService.deleteQuestion(questionId);
	}
}
