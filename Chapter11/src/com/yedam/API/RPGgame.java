package com.yedam.API;

public class RPGgame implements Keypad{
	
	private int mode;
	
	@Override
	public void turnOn() {
		System.out.println("RPGgame 실행");
	}
	
	@Override
	public void leftUpButton() {
		System.out.println("캐릭터가 위쪽으로 이동한다");
	}

	@Override
	public void leftDownButton() {
		System.out.println("캐릭터가 아래쪽으로 이동한다");
	}

	@Override
	public void rightUpButton() {
		
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
