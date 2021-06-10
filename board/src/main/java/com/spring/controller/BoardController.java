package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.domain.BoardVO;
import com.spring.service.BoardService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("전체목록 조회");
		List<BoardVO> list = service.list();
		model.addAttribute("list", list);
	}
	
	@GetMapping("/register")
	public void register() {
		log.info("새 글 등록 폼 요청");
	}
	
	// 게시글 등록
	@PostMapping("/register")
	public String tegisterPost(BoardVO vo) {
		log.info("새 글 등록 요청 " + vo);
		
		if(service.insert(vo)) {
			return "redirect:list";       // redirect:/board/list
		} else {
			return "redirect:register";   // redirect:/board/register
		}
	}
	
	// read?bno=?? 데이터 읽어 온 후 read.jsp
	//  /board/modify?bno=7
	@GetMapping({"/read", "/modify"})
	public void read(int bno, Model model) {
		log.info("글 하나 가져오기 " + bno);
		
		BoardVO vo = service.read(bno);
		model.addAttribute("vo", vo);
	}
	
	// modify + post 수정한 후 list
	@PostMapping("/modify")
	public String modify(BoardVO vo) {
		log.info("수정 요청 " + vo);
		service.update(vo);
		return "redirect:list";
		
	}
	
}
