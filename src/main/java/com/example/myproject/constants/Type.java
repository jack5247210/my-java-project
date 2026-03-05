package com.example.myproject.constants;

import org.springframework.util.StringUtils;

public enum Type {

	SINGLE("Single"),
	MULTI("Multi"),
	TEXT("Text");
	
	private String Type;

	private Type(String type) {
		Type = type;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
	
	public static boolean check(String input) {
		//方法一:
		if(!StringUtils.hasText(input)){
			return false;
		}
		if(input.equalsIgnoreCase(SINGLE.getType())) {
			return true;
		}
		if(input.equalsIgnoreCase(MULTI.getType())) {
			return true;
		}
		if(input.equalsIgnoreCase(TEXT.getType())) {
			return true;
		}
		//方法二：
		/*if(input.equalsIgnoreCase(SINGLE.getType())||。。。以上三個可以用||進行整合) {
			return true;
		}
		*/
		/*
		 * 方法三：values()取得的事這個enum中所有的列舉對象
		 * for(Type type:values(){
		 * if(input.equalsIgnoreCase(type.getType())){
		 * return true;
		 * }
		 * }
		 * return false;
		 */
		return false;
	}
	public static boolean isChoiceType(String input) {
//		if(input.equalsIgnoreCase(SINGLE.getType())
//				||input.equalsIgnoreCase(MULTI.getType()) {
//			return true;
//			
//		}
//		return false;
//		更簡單的邏輯寫法：
		return input.equalsIgnoreCase(SINGLE.getType())
				|| input.equalsIgnoreCase(MULTI.getType());

	}
	
}
