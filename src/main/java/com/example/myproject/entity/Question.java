package com.example.myproject.entity;

import com.example.myproject.constants.ValidationMsg;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "question")
@IdClass(value = QuestionId.class)
public class Question {
////這幾個都要要檢查，因為DAO層“插入”的時候是需要這個欄位的。
	@Id
	@Column(name = "quiz_id")
	private int quizId;//一開始沒有，新增完問卷ID後才有了,所以沒有填完問卷，不管填什麼進資料庫都不會理我們，所以不用檢查
	//update的時候，要檢查問題的quizId和問卷的quizId是要一樣的
	
	@Min(value = 1, message = ValidationMsg.QUESTION_ID_ERROR)
	@Id
	@Column(name = "question_id")
	private int questionId;
	
	@NotBlank(message = ValidationMsg.QUESTION_ERROR)
	@Column(name = "question")
	private String question;//要檢查
	
	@Column(name = "type")
	private String type;//要檢查
	
	@Column(name = "is_required")
	private boolean required;
	
	@Column(name = "options")
	private String options;

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

}
