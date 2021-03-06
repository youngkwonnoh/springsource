package com.spring.di;

public class SamsungTV implements TV {

	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("SamsungTV - 객체 생성(1)");
	}

	public SamsungTV(Speaker speaker) {
		super();
		this.speaker = speaker;
		System.out.println("SamsungTV - 객체 생성(2)");
	}
	
	public SamsungTV(Speaker speaker, int price) {
		super();
		this.speaker = speaker;
		this.price = price;
		System.out.println("SamsungTV - 객체 생성(3)");
		System.out.println("SamsungTV 가격 - " + this.price);
	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	
	@Override
	public void turnOn() {
		System.out.println("SamsungTV - 파워 On");

	}

	@Override
	public void turnOff() {
		System.out.println("SamsungTV - 파워 Off");

	}

	@Override
	public void soundUp() {
		// System.out.println("SamsungTV - volumeUp");
		speaker.volumeUp();

	}

	@Override
	public void soundDown() {
		// System.out.println("SamsungTV - volumeDown");
		speaker.volumeDown();

	}

}
