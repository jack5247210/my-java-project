package com.example.myproject.entity;

import java.io.Serializable;

public class FillinId implements Serializable {

	private int quizId;
	
	private int questionId;
	
	private String userphone;

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	
	
	
	
}
