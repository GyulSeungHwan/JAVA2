package com.yedam.inter;

public interface RemoteControl {
	//상수 => static final이 생략
	public int MAX_VOLUME = 10;
	public static final int MIN_VOLUME = 0;
	
	//interface는 전부 다 추상 메소드다
	//추상 메소드 -> abstract 생략
	public void turnOn();
	public abstract void turnOff();
	//=public void turnOff()랑 같음
	public void setVolume(int volume);
}
