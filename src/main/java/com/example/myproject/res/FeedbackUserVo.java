package com.example.myproject.res;

import java.time.LocalDateTime;
import java.util.List;

import com.example.myproject.vo.AnswerVo;

public class FeedbackUserVo {

	private String userphone;
	private String name;
	private LocalDateTime fillin_time;
	private List<AnswerVo> answerVoList;
	private int age;
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
	public LocalDateTime getFillin_time() {
		return fillin_time;
	}
	public void setFillin_time(LocalDateTime fillin_time) {
		this.fillin_time = fillin_time;
	}
	public List<AnswerVo> getAnswerVoList() {
		return answerVoList;
	}
	public void setAnswerVoList(List<AnswerVo> answerVoList) {
		this.answerVoList = answerVoList;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public FeedbackUserVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FeedbackUserVo(String userphone, String name, LocalDateTime fillin_time, List<AnswerVo> answerVoList,
			int age) {
		super();
		this.userphone = userphone;
		this.name = name;
		this.fillin_time = fillin_time;
		this.answerVoList = answerVoList;
		this.age = age;
	}
	public FeedbackUserVo(String userphone, String name, LocalDateTime fillin_time, int age) {
		super();
		this.userphone = userphone;
		this.name = name;
		this.fillin_time = fillin_time;
		this.age = age;
	}
	public FeedbackUserVo(String userphone, String name, LocalDateTime fillin_time, List<AnswerVo> answerVoList) {
		super();
		this.userphone = userphone;
		this.name = name;
		this.fillin_time = fillin_time;
		this.answerVoList = answerVoList;
	}

	
	
	

}
