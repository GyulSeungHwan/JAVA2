package com.yedam.API;

public class GameExample {
	public static void main(String[] args) {
		Keypad rc;
		rc = new RPGgame();
		
		rc.turnOn();
		rc.leftUpButton();
		rc.rightUpButton();
		rc.changeMode(1);
		rc.rightUpButton();
		rc.rightDownButton();
		rc.leftDownButton();
		rc.changeMode(0);
		rc.rightDownButton();
		
		System.out.println("=======================");
		
		rc = new ArcadeGame();
		
		rc.turnOn();
		rc.leftUpButton();
		rc.rightUpButton();
		rc.leftDownButton();
		rc.changeMode(1);
		rc.rightUpButton();
		rc.leftUpButton();
		rc.rightDownButton();
	}
}
