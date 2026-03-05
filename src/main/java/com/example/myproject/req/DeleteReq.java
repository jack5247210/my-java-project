package com.example.myproject.req;

import java.util.List;

import com.example.myproject.entity.Question;

public class DeleteReq {

	private List<Integer> quizIdList;

	public List<Integer> getQuizIdList() {
		return quizIdList;
	}

	public void setQuizIdList(List<Integer> quizIdList) {
		this.quizIdList = quizIdList;
	}

	public DeleteReq(List<Integer> quizIdList) {
		super();
		this.quizIdList = quizIdList;
	}

	public DeleteReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
