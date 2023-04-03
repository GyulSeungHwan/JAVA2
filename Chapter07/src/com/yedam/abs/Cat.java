package com.yedam.abs;

public class Cat extends Animal {
	
	public Cat() {
		this.kind = "포유류"; //super.kind랑 같음
	}
	@Override
	public void sound() {
		System.out.println("야옹");
	}

}
