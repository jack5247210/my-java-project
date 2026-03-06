package com.example.myproject.res;

import java.util.List;

import com.example.myproject.vo.AnswerVo;

public class FeedbackRes extends BasicRes {

	private int quizId;
	
	private String name;


	private String userphone;


	private String password;


	private int age;

	private List<AnswerVo> answerVoList;

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public FeedbackRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeedbackRes(int code, String message) {
		super(code, message);
	}

	public FeedbackRes(int code, String message, int quizId, String name, String userphone, String password, int age,
			List<AnswerVo> answerVoList) {
		super(code, message);
		this.quizId = quizId;
		this.name = name;
		this.userphone = userphone;
		this.password = password;
		this.age = age;
		this.answerVoList = answerVoList;
	}

	public FeedbackRes(int quizId, String name, String userphone, int age) {
		super();
		this.quizId = quizId;
		this.name = name;
		this.userphone = userphone;
		this.age = age;
	}

	public FeedbackRes(int code, String message, int quizId, String name, String userphone, int age,
			List<AnswerVo> answerVoList) {
		super(code, message);
		this.quizId = quizId;
		this.name = name;
		this.userphone = userphone;
		this.age = age;
		this.answerVoList = answerVoList;
	}

	
}
