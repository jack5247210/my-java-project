package com.example.myproject.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "fillin")
@IdClass(value = FillinId.class)
public class Fillin {

	@Id
	@Column(name = "quizId")
	private int quizId;
	
	@Id
	@Column(name = "questionId")
	private int questionId;
	
	@Id
	@Column(name = "user_phone")
	private String userphone;
	
	@Column(name = "answer")
	private String answer;
	
	@Column(name = "fillinTime")
	private LocalDateTime fillinTime;

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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public LocalDateTime getFillinTime() {
		return fillinTime;
	}

	public void setFillinTime(LocalDateTime fillinTime) {
		this.fillinTime = fillinTime;
	}

	
	
	
}
