package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class SecurityController {
	
	@GetMapping("/login")
	public String loginGet() {
		log.info("security-loginForm 요청");
		
		return "/security/loginForm";
	}
	
	@GetMapping("/user-page")
	public String userPage() {
		log.info("security-userpage 요청");
		
		return "/security/UserPage";
	}
	
	@GetMapping("/admin-page")
	public String adminPage() {
		log.info("security-adminpage 요청");
		
		return "/security/AdminPage";
	}
	
	@GetMapping("/login-error")
	public String loginError(Model model) {
		log.info("로그인 실패");
		
		model.addAttribute("loginError", "아이디나 비밀번호가 올바르지 않습니다.");
		
		return "/security/loginForm";
	}
	
}
