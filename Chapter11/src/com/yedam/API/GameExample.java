package com.yedam.API;

public class GameExample {
	public static void main(String[] args) {
		Keypad rc;
		rc = new RPGgame();
		rc = new ArcadeGame();
		
		rc.turnOn();
		rc.changeMode(0);
		
		
	}
}
