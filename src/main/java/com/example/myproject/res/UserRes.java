package com.example.myproject.res;

import com.example.myproject.req.RegisterReq;

public class UserRes extends RegisterReq {

	private String userphone;
	
	private String name;
	
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public UserRes(String userphone, String name, int age) {
		super();
		this.userphone = userphone;
		this.name = name;
		this.age = age;
	}
	
	
}
