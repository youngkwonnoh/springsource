package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component("log")
public class LogAdvice {
//	public void beforeLog() {
//		System.out.println("[공통로그] 비즈니스 로직 수행 전 호출");
//	}
		
//	public void afterLog() {
//		System.out.println("[공통로그] 비즈니스 로직 수행 후 호출");
//	}
	
	public void aroudnLog(ProceedingJoinPoint pjp) {
		System.out.println("[공통로그] 비즈니스 로직 수행 전 호출");
		
		try {
			pjp.proceed(); // 실제 수행할 메소드 호풀
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("[공통로그] 비즈니스 로직 수행 전 호출");
	}
}
