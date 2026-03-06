package com.example.myproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.myproject.entity.User;

import jakarta.transaction.Transactional;

public interface UserDao extends JpaRepository<User, String> {

	// 新增user
	@Modifying
	@Transactional
	@Query(value = "insert into user (user_phone,name,age,password) "//
			+ "values (?1,?2,?3,?4)", nativeQuery = true)
	public void insert(String userphone, String name, int age, String password);
	
	//取得特定email的次數，檢查email是否已經存在---檢查email是否已被註冊過
		@Query(value = "SELECT COUNT(user_phone) from  user where user_phone=?1 ", nativeQuery = true)
		public int getPhoneCount(String userphone);
		
		
		@Query(value = "SELECT *  from  user where user_phone=?1 ", nativeQuery = true)
		public User getByPhone(String userphone);
		
		
}
