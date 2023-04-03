package com.yedam.API;

public interface Keypad {
	public int NORMAL_MODE = 0;
	public int HARD_MODE = 1;
	
	public void turnOn();
	public void leftUpButton();
	public void leftDownButton();
	public void rightUpButton();
	public void rightDownButton();
	public void changeMode(int mode);
}
