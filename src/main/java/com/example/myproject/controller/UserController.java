package com.example.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myproject.constants.ReplyMessage;
import com.example.myproject.req.LoginReq;
import com.example.myproject.req.RegisterReq;
import com.example.myproject.res.BasicRes;
import com.example.myproject.res.LoginRes;
import com.example.myproject.res.UserRes;
import com.example.myproject.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
//@RequestMapping("/api/quiz")最好有，沒有也沒關係
@CrossOrigin(origins = "http://localhost:4200")//如果前端用到session，跨網域，可能加上沒效果，後續再講
public class UserController {

	
	@Autowired
	private UserService userservice;
	
	//註冊
	@PostMapping("register")
	public BasicRes register(@RequestBody RegisterReq req) {
			return userservice.register(req);
	}
	
	//登入
	@PostMapping("login")
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
	public LoginRes login(@RequestBody LoginReq req, HttpSession session) {
	    LoginRes res = userservice.login(req);
	    if (res.getCode() == ReplyMessage.SUCCESS.getCode()) {
	        session.setAttribute("userphone", res.getUserphone());
	        session.setAttribute("isAdmin", res.isAdmin());
	    }
	    return res;
	}
	
	//登出
	@GetMapping("logout")
	public BasicRes logout(HttpSession session) {
	    session.invalidate();  // 使 session 失效
	    return new BasicRes(ReplyMessage.SUCCESS.getCode(), ReplyMessage.SUCCESS.getMessage());
	}
}
