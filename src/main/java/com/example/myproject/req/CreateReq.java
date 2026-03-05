package com.example.myproject.req;

import java.time.LocalDate;
import java.util.List;

import com.example.myproject.constants.ValidationMsg;
import com.example.myproject.entity.Question;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public class CreateReq {

	private String title;
	
	private String description;
//	pattern:範例.榜樣
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate StartDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate EndDate;// 在數據庫裡是DateTime
	
	private boolean published;
	/* 嵌套驗證: 針對自定義的物件(class)中的屬性
	 * @Valid: 為了讓嵌套驗證中的屬性限制生效，就是 Question 中的屬性限制*/
	@Valid
	@NotEmpty(message = ValidationMsg.QUESTION_LIST_IS_EMPTY)
	private List<Question> questionList;//問卷和問題的關係是一對多，一所以這樣寫是錯的，要用list

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartDate() {
		return StartDate;
	}

	public void setStartDate(LocalDate startDate) {
		StartDate = startDate;
	}

	public LocalDate getEndDate() {
		return EndDate;
	}

	public void setEndDate(LocalDate endDate) {
		EndDate = endDate;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	
	
}
