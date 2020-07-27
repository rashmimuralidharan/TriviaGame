package com.rashmi.triviagame.Questions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionsService {
	
	@Autowired
	private QuestionsRepository questionsRepository;
	
	public List<Question> getAllQuestions(){
		List<Question> questions = new ArrayList<Question>();
		questionsRepository.findAll()
		.forEach(questions::add);
		return questions;
	}
	
	public Question getQuestion(String id) {
		return questionsRepository.findOne(id);
	}

	public void addQuestion(Question question) {
		questionsRepository.save(question);
	}

	public void updateQuestion(String id, Question question) {
		questionsRepository.save(question);
	}
		
	
	public void deleteQuestion(String id) {
		questionsRepository.delete(id);
	}

}
