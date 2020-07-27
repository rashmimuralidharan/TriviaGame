package com.rashmi.triviagame.Quiz;

import org.springframework.data.repository.CrudRepository;

import com.rashmi.triviagame.Questions.Question;

public interface QuizRepository extends CrudRepository<Quiz, String> {

}
