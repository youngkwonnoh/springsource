package com.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j2;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j2
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		log.info("Welcome home!");
		
		return "index";
	}
	
	@RequestMapping(value = "/bookrest", method = RequestMethod.GET)
	public void bookrest() {
		log.info("rest");
	}

	@RequestMapping(value = "/book-insert", method = RequestMethod.GET)
	public String bookInsert() {
		log.info("rest insert");
		return "insertForm";
	}
	
	
}
