package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.domain.PageVO;
import com.spring.service.BoardService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		log.info("전체 리스트 요청");
		
		// 사용자가 선택한 페이지 게시물
		List<BoardVO> list = service.list(cri);
		// 전체 게시물 수
		int total = service.total(cri);
		
		model.addAttribute("list", list);
		model.addAttribute("pageVO", new PageVO(cri, total));
		
	}
	
	@GetMapping("/register")
	public void register() {
		log.info("새 글 등록 폼 요청");
	}
	
	// 게시글 등록
	@PostMapping("/register")
	public String tegisterPost(BoardVO vo, RedirectAttributes rttr) {
		log.info("새 글 등록 요청 " + vo);
		
		if(service.insert(vo)) {
//			log.info("입력된 글 번호 " + vo.getBno());
			rttr.addFlashAttribute("result", vo.getBno());
			return "redirect:list";       // redirect:/board/list
		} else {
			return "redirect:register";   // redirect:/board/register
		}
	}
	
	// read?bno=?? 데이터 읽어 온 후 read.jsp
	//  /board/modify?bno=7
	@GetMapping({"/read", "/modify"})
	public void read(int bno,@ModelAttribute("cri") Criteria cri, Model model) {
		log.info("글 하나 가져오기 " + bno + " cri : " + cri);
		
		BoardVO vo = service.read(bno);
		model.addAttribute("vo", vo); // /board/read or /board/modify
	}
	
	// modify + post 수정한 후 list
	@PostMapping("/modify")
	public String modify(BoardVO vo, Criteria cri, RedirectAttributes rttr) {
		log.info("수정 요청 " + vo + " 페이지 나누기 " + cri);
		
		service.update(vo);
		rttr.addFlashAttribute("result", "성공");
		
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:list";
		
	}
	
	// 게시글 삭제
	@PostMapping("/remove")
	public String remove(int bno, Criteria cri, RedirectAttributes rttr) {
		log.info("게시글 삭제" + bno);
		
		service.delete(bno);
		rttr.addFlashAttribute("result", "성공");
		
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		return "redirect:list";
	}
	
}
