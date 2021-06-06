package com.spring.member;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.MemberVO;
import com.spring.service.MemberService;

public class MemberClient {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		MemberService service = (MemberService) ctx.getBean("service");
		
		// 전체 조회 확인
		List<MemberVO> list = service.getList();
		for(MemberVO vo:list) {
			System.out.println(vo);
		}
		System.out.println("-----------------------------------------");
	
		// 추가 되는지 확인
		MemberVO vo1 = new MemberVO();
		vo1.setUserid("kan123");
		vo1.setPassword("kan123!@#");
		vo1.setName("강호동");
		vo1.setGender("남");
		vo1.setEmail("kang123@gmail.com");
		
		boolean insertFlag = service.insert(vo1);
		System.out.println(insertFlag ? "성공":"실패");
		
//		// 추가 후 전체 조회
//		list = service.getList();
//		for(MemberVO vo:list) {
//			System.out.println(vo);
//		}
		
		//update

		
		// login 확인
		System.out.println(service.login("hong123", "hong123!@#"));
		System.out.println("-----------------------------------------");
		

		// 삭제 확인
		System.out.println(service.delete("kan123", "kan123!@#")?"성공":"실패");
		System.out.println("-----------------------------------------");
		
//		// 삭제 후 전체 조회
		list = service.getList();
		for(MemberVO vo:list) {
			System.out.println(vo);
		}
	}

}
