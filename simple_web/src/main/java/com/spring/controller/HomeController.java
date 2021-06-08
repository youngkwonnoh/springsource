package com.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j2
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login() {
		log.info("login 요청...");
	}
	
	@RequestMapping("/logout")
	public void logout() {
		log.info("logout 요청");
	}
	
	@RequestMapping("/doA")
	public String doA() {
		log.info("doA 요청");
		return "board/read";
	}
	
	@RequestMapping("/doC")
	public ModelAndView doC() {
		log.info("/doC 요청");
		// Model => request 영역
		ModelAndView mav = new ModelAndView();
		mav.addObject("test", "ModelAndView"); // == request.setAttribute();
		mav.setViewName("result");
		return mav;
	}
	
	@GetMapping("/doB")
	public String doB(RedirectAttributes rttr) {
		log.info("doB 요청");
		
		// 값을 유지시키고 싶다면?
		// 주소를 달아서 보냄
		rttr .addAttribute("age1", 20); // http://localhost:8081/?age=10  path += "bno=3&page=1"
		
		// session 객체 사용(임시)
		rttr.addFlashAttribute("age", 10);
		
		return "redirect:/";
	}
}








