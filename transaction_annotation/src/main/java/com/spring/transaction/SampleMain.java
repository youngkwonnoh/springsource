package com.spring.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.SampleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SampleMain {
	public static void main(String[] args) {

		log.info("main 실행");
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		SampleService service = (SampleService) ctx.getBean("sample");
		
		String data = "Starry\r\n"
				+ "starry night\r\n"
				+ "Paint your paletter blue and grey\r\n"
				+ "Look out on a summer day";
		service.addData(data);
	}

}
