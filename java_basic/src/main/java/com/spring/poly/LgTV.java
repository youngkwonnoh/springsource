package com.spring.poly;

public class LgTV implements TV {

	@Override
	public void turnOn() {
		System.out.println("LG TV - 전원 On");

	}

	@Override
	public void turnOff() {
		System.out.println("LG TV - 전원 Off");

	}

	@Override
	public void soundUp() {
		System.out.println("LG TV - 볼륨 Up");

	}

	@Override
	public void soundDown() {
		System.out.println("LG TV - 볼륨 Down");

	}

}
