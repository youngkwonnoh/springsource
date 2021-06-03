package com.spring.scan;

import org.springframework.stereotype.Component;

@Component("speaker1")
public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("===> SonySpeaker 객체 생성");
	}
	@Override
	public void volumeUp() {
		System.out.println("===> SonySpeaker volume Up");
	}
	@Override
	public void volumeDown() {
		System.out.println("===> SonySpeaker volume Down");
	}
}
