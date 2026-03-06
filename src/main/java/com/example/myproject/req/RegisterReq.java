package com.example.myproject.req;

public class RegisterReq {

	private String userphone;
	
	private String name;
	
	private String password;
	
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

	public RegisterReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegisterReq(String userphone, String name, String password, int age) {
		super();
		this.userphone = userphone;
		this.name = name;
		this.password = password;
		this.age = age;
	}
	
	
}
