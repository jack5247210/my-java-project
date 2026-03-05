package com.example.myproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "user_phone")
	private String userphone;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private int age;

	@Column(name = "password")
	private String password;
	
	@Column(name = "is_admin")
    private boolean isAdmin;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	

}
