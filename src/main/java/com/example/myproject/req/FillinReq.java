package com.example.myproject.req;

import java.time.LocalDateTime;
import java.util.List;

import com.example.myproject.entity.Fillin;
import com.example.myproject.vo.AnswerVo;

public class FillinReq extends Fillin {

	private int quizId;
	
	private String userphone;
	
	private String name;
	
	private String answer;
	
	private int age;
	
	private List<AnswerVo> answerVoList;

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<AnswerVo> getAnswerVoList() {
		return answerVoList;
	}

	public void setAnswerVoList(List<AnswerVo> answerVoList) {
		this.answerVoList = answerVoList;
	}

	
	
	
}
