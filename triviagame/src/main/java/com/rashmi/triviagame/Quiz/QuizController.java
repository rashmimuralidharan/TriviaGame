package com.rashmi.triviagame.Quiz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rashmi.triviagame.Questions.Question;

@RestController
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@RequestMapping("/quizzes")
	public List<Quiz> getAllQuiz(){
		return quizService.getAllQuiz();
	}
	
	@RequestMapping(method = RequestMethod.POST, value= "/quizzes")
	public void addQuiz(@RequestBody Quiz quiz) {
		quizService.addQuiz(quiz);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value= "/quizzes/{quizId}")
	public void updateQuiz(@RequestBody Quiz quiz, @PathVariable String quizId) {
		quizService.updateQuiz(quizId, quiz);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value= "/quizzes/{quizId}")
	public void deleteQuiz(@PathVariable String quizId) {
		quizService.deleteQuiz(quizId);
	}
	

}
