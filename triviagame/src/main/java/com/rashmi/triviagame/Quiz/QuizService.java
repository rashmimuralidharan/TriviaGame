package com.rashmi.triviagame.Quiz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rashmi.triviagame.Questions.Question;
import com.rashmi.triviagame.Questions.QuestionsRepository;
import com.rashmi.triviagame.Questions.QuestionsService;

@Service
public class QuizService {
	
	private static final int USERS_PER_QUIZ = 2;
	private static final int QUESTIONS_PER_QUIZ = 2;
	
	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	QuestionsService questionsService;
	
	public List<Quiz> getAllQuiz(){
		List<Quiz> quiz = new ArrayList<Quiz>();
		quizRepository.findAll()
		.forEach(quiz::add);
		return quiz;
	}
	
	public Quiz getQuiz(String id) {
		return quizRepository.findOne(id);
	}
	
	public void addQuiz(Quiz quiz) {
		quizRepository.save(quiz);
	}

	public void updateQuiz(String id, Quiz quiz) {
		quizRepository.save(quiz);
	}
		
	
	public void deleteQuiz(String id) {
		quizRepository.delete(id);
	}
	
	public String getQuizForuser(String userId) {
		
		List<Quiz> quizzes = getAllQuiz();
		for(Quiz q: quizzes) {
			if(q.getUserCount()<USERS_PER_QUIZ) {
				q.setUserCount(q.getUserCount()+1);
				quizRepository.save(q);
				return q.getQuizId();
			}
		}
		
		String quizId = (quizzes.size() + 1) + " ";
		Quiz newQuiz = new Quiz();
		newQuiz.setQuizId(quizId);
		
		HashSet<Question> selectedQuestionList = new HashSet<Question>();		
		List<Question> questionList = questionsService.getAllQuestions();
		HashSet<Integer> selectedQuestionNumbers = new HashSet<Integer>();
		
		Random rand = new Random();
		
		int i =0;
		while(i<QUESTIONS_PER_QUIZ) {
			int questionsNumber;
			do {
				questionsNumber = rand.nextInt(questionList.size());
			} while (selectedQuestionNumbers.contains(questionsNumber));
			selectedQuestionNumbers.add(questionsNumber);
			selectedQuestionList.add(questionList.get(questionsNumber));
			i++;
		}
		newQuiz.setQuestions(selectedQuestionList);
		newQuiz.setUserCount(1);
		addQuiz(newQuiz);
		
		return quizId;
	}

	public boolean canStartQuiz(String quizId) {
		Quiz quiz = getQuiz(quizId);
		return quiz.getUserCount() == USERS_PER_QUIZ;
	}
}
