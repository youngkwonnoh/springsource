package com.spring.book;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BookVO;
import com.spring.service.BookService;

public class BookClient {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		BookService service = (BookService) ctx.getBean("service");
		
		// 입력
		BookVO vo = new BookVO();
		vo.setCode(1010);
		vo.setTitle("테스트북");
		vo.setWriter("맹구");
		vo.setPrice(25000);
		System.out.println(service.insert(vo) ? "성공" : "실패");
		
		// 수정
		BookVO update = new BookVO();
		update.setCode(1010);
		update.setPrice(30000);
		System.out.println(service.update(vo) ? "성공" : "실패");
		
		// 삭제
		System.out.println(service.delete(1010) ? "성공" : "실패");
		
		//도서 정보 하나 가져오기
		System.out.println(service.getRow(1005));
		System.out.println();
		
		// 전체 리스트
		List<BookVO> list = service.getList();
		for(BookVO vo1:list) {
			System.out.println(vo1);
		}

	}

}
