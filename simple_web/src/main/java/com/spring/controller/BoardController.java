package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/board/*")
@Log4j2
public class BoardController {
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read() {
		log.info("read 요청....");
	}
	
	@GetMapping("/insert")
	public void insert() {
		log.info("insert 요청....");
	}
	
	@GetMapping("/remove")
	public void remove() {
		log.info("remove 요청....");
	}
	
	@GetMapping("/update")
	public void update() {
		log.info("update 요청....");
	}
}
