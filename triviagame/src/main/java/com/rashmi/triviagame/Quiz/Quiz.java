package com.rashmi.triviagame.Quiz;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.rashmi.triviagame.Questions.Question;
@Entity
@Table(name = "quizzes")
public class Quiz {
	
	@Id
	private String quizId;

	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "quiz_question",
            joinColumns = { @JoinColumn(name = "quizId") },
            inverseJoinColumns = { @JoinColumn(name = "questionId") })
	private Set<Question> questions = new HashSet<Question>();
	private int userCount;
	
	public Quiz() {
		super();
	}

	public Quiz(String quizId, Set<Question> questions, int userCount) {
		super();
		this.quizId = quizId;
		this.questions = questions;
		this.userCount = userCount;
	}

	public String getQuizId() {
		return quizId;
	}

	public void setQuizId(String quizId) {
		this.quizId = quizId;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	
}
