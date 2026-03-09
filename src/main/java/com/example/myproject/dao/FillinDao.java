package com.example.myproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.myproject.entity.Fillin;
import com.example.myproject.entity.FillinId;

import jakarta.transaction.Transactional;
@Repository
public interface FillinDao extends JpaRepository<Fillin, FillinId>{

	@Modifying
	@Transactional
	@Query(value = "insert into fillin (quiz_id,question_id,user_phone,answer,fillin_time)"
			+ " values(?1, ?2, ?3, ?4, NOW())", nativeQuery = true)
	public void insert(int quizId, int questionId, String userphone, String answer );
	// 其中LocalDate now不需要填，會帶入預設值curdate()

	@Query(value = "select * from fillin where quiz_Id=?1", nativeQuery = true)
	public List<Fillin> getByQuizId(int quizId);
	
	@Query(value = "select * from fillin where quiz_Id = ?1 and user_phone = ?2", nativeQuery = true)
	public List<Fillin> getByQuizIdAndUserphone(int quizId, String uesrphone);// 補上

	
}
