package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/sample/*")
public class SampleController {
	
	// http://localhaos:8081/basic/sample
	@RequestMapping("/basic")
	public void basic() {
		log.info("basic 요청 ......");
	}
	// http://localhaos:8081/sample/sample	
	@RequestMapping("/sample")
	public void sample() {
		log.info("basic 요청 ......");
	}
	
}
