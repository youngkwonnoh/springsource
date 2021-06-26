package com.spring.board;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BoardVO;
import com.spring.service.BoardService;

public class BoardClient {
	public static void main(String[] args) {
		// Service => DAO
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		BoardService service = (BoardService) ctx.getBean("service");

//		BoardVO vo = new BoardVO();
//		vo.setTitle("스프링 컨테이너");
//		vo.setContent("스프링 컨테이너의 사용");
//		vo.setWriter("홍길동");
//		
//		boolean insertFlag = service.insert(vo);
//		System.out.println(insertFlag ? "성공" : "실패");
//		
		// update
		BoardVO vo = new BoardVO();
		vo.setTitle("스프링 컨테이너2");
		vo.setContent("스프링 컨테이너의 사용2");
		vo.setBno(2);
		System.out.println(service.update(vo)?"성공":"실패");
		
		System.out.println("----------------------------------");
		
		// 하나 조회
		System.out.println(service.getRow(2));
		
		System.out.println("----------------------------------");
		
		// 삭제
		System.out.println(service.delete(2)?"성공":"실패");
		
		System.out.println("----------------------------------");
		// 전체 조회
		List<BoardVO> list = service.getList();
		for(BoardVO vo1:list) {
			System.out.println(vo1);
//			System.out.println(vo1.getBno());
//			System.out.println(vo1.getTitle());
//			System.out.println(vo1.getContent());
//			System.out.println(vo1.getWriter());
//			System.out.println(vo1.getRegdate());
//			System.out.println(vo1.getUpdatedate());
		}
	}

}
