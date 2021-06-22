package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.domain.CalcVO;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/calc/*")
public class AddController {
	
	@GetMapping(value="/add")
	// @RequestMapping(value="/add" method=RequestMethod.GET)
	public void addForm() {
		log.info("add.jsp 요정");
	}
	
	// add.jsp 값 가져오기
	@PostMapping("/add")
	public void addPost(int num1, int num2) {
		log.info("add 값 가져오기");
		log.info("num1 : " + num1);
		log.info("num2 : " + num2);
	}
	
	@GetMapping("/four")
	public void fourGet() {
		log.info("four form 요청");
	}
	
//	@PostMapping("/four")
//	public void fourPost(int num1, int num2, String op) {
//		log.info("four 입력값 가져오기");
//		log.info("num1 : " + num1);
//		log.info("num2 : " + num2);
//		log.info("op : " + op);
	
	@PostMapping("/four")
	public void fourPost(CalcVO calc, @ModelAttribute("page") int page) {
		log.info("four 입력값 가져오기");
		log.info("num1 : " + calc.getNum1());
		log.info("num2 : " + calc.getNum2());
		log.info("op : " + calc.getOp());
		log.info("page : " + page);
		
		// page 값을 유지시키고 싶다면?
		// model.addAttribute("page", page);
	}
}
