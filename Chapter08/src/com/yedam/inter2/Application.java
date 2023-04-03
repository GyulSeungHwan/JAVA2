package com.yedam.inter2;

public class Application {
	public static void main(String[] args) {
		A a = new B();
		a.info();
		a = new C();
		a.info();
		// a <- b <- c
		//b에 넣어둔 메소드를 c가 받아와서 info를 실행
	}
}
