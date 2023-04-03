package com.yedam.inheri;

public class Exam extends OverrideExam {
	
	@Override
	public void method1() {
		
		System.out.println("자식클래스 method1");
		super.method1();
		super.method2();
	}
}
