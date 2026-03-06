package com.example.myproject.res;

public class LoginRes extends BasicRes {
    
	private boolean admin;  // 是否為管理員
    private String userphone; // 可選，如果需要前端顯示

    public LoginRes(int code, String message) {
        super(code, message);
    }

    public LoginRes(int code, String message, boolean admin, String userphone) {
        super(code, message);
        this.admin = admin;
        this.userphone = userphone;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }
}