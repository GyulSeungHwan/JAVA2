package com.yedam.API;

public class ArcadeGame implements Keypad{
	
	private int mode;
	
	@Override
	public void turnOn() {
		System.out.println("ArcadeGame 실행");
	}

	@Override
	public void leftUpButton() {
		System.out.println("캐릭터가 앞쪽으로 이동한다");
	}

	@Override
	public void leftDownButton() {
		System.out.println("캐릭터가 뒤쪽으로 이동한다");
	}

	@Override
	public void rightUpButton() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rightDownButton() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeMode(int mode) {
		// TODO Auto-generated method stub
		
	}
	
}
