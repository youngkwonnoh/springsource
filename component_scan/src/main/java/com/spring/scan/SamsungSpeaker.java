package com.spring.scan;

import org.springframework.stereotype.Component;

@Component("speaker2")
public class SamsungSpeaker implements Speaker {
	public SamsungSpeaker() {
		System.out.println("=== SamsungSpeaker 객체 생성");
	}
	public void volumeUp() {
		System.out.println("=== SamsungSpeaker soundUp");
	}
	public void volumeDown() {
		System.out.println("=== SamsungSpeaker soundDown");
	}
}
