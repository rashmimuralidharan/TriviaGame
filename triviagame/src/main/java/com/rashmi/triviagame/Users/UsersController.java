package com.rashmi.triviagame.Users;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rashmi.triviagame.Questions.QuestionsService;
import com.rashmi.triviagame.Quiz.Quiz;
import com.rashmi.triviagame.Quiz.QuizService;

@RestController
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private QuestionsService questionsService;
	
	@RequestMapping("/users")
	public List<User> getAllUsers() {
		return usersService.getAllUsers();
	}
	
	@RequestMapping("/users/{userId}")
	public User getUser(@PathVariable String userId) {
		return usersService.getUser(userId);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value= "/users")
	public void addUser(@RequestBody User user) {
		usersService.addUser(user);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value= "/users/{userId}")
	public void updateUser(@RequestBody User user, @PathVariable String userId) {
		usersService.updateUser(userId, user);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value= "/users/{userId}")
	public void deleteUser(@PathVariable String userId) {
		usersService.deleteUser(userId);
		
	}
	
	@RequestMapping("/users/{userId}/password/{passwordText}")
	public boolean getUser(@PathVariable String userId, @PathVariable String passwordText) {
		User user=usersService.getUser(userId);
		return user.getPassword().equals(passwordText);
	}
	
	@RequestMapping("/getQuiz/{userId}")
	public String getQuiz(@PathVariable String userId) {
		return quizService.getQuizForuser(userId);
	}
	
	@RequestMapping("/canStartQuiz/{quizId}")
	public boolean canStartQuiz(@PathVariable String quizId) {
		return quizService.canStartQuiz(quizId);
	}
	
	@RequestMapping("/isCorrectAnswer/{userId}/question/{questionId}/answer/{answerText}")
	public boolean canStartQuiz(@PathVariable String userId,@PathVariable String questionId,@PathVariable String answerText) {
		return questionsService.getQuestion(questionId).getAnswer().equals(answerText);
	}

}
