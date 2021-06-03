package com.spring.basic;

public class MessageBeanKEn implements MessageBean {
	@Override
	public void sayHello(String name) {
		System.out.println("Hello!!" + name);
	}
}
