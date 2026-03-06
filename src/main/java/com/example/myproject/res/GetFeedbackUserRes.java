package com.example.myproject.res;

import java.util.List;

public class GetFeedbackUserRes extends BasicRes {

	private List<FeedbackUserVo> userVoList;

	public GetFeedbackUserRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetFeedbackUserRes(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}
	
	public GetFeedbackUserRes(List<FeedbackUserVo> userVoList) {
		super();
		this.userVoList = userVoList;
	}
	
	public GetFeedbackUserRes(int code, String message, List<FeedbackUserVo> userVoList) {
		super(code, message);
		this.userVoList = userVoList;
	}

	
	public List<FeedbackUserVo> getUserVoList() {
		return userVoList;
	}

	public void setUserVoList(List<FeedbackUserVo> userVoList) {
		this.userVoList = userVoList;
	}
	
}
