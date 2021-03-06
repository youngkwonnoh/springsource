package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
//		SamsungTV samsung = new SamsungTV();
//		samsung.turnOn();
//		samsung.turnOff();
		
		// 응집도 높이고, 결합도 낮추기
		//
		// 부모 = 자식(extends, implements)
//		TV tv = new SamsungTV(new SamsungSpeaker());
//		tv.turnOn(); // => SamsungTV -파워 On
//		tv.soundUp();
//		tv.soundDown();
		// ((SamsungTV)tv).setSpeaker(new Speaker()); // 형변환 후 ClassCastExcption이 생기는지 확인한다.
//		tv.turnOff();
		
//		tv = new LgTV();
//		tv.turnOn(); // LG TV - 전원 On
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config2.xml");
		TV tv= (TV) ctx.getBean("samTv2");
		
		tv.turnOn();
		tv.soundUp();
		tv.soundDown();
		tv.turnOff();
	}

}
