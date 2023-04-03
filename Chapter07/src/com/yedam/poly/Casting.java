package com.yedam.poly;

public class Casting {
	
	//매개변수를 활용한 다형성
	public static void method1(Parent parent) {
		if(parent instanceof Child) {
			Child child = (Child)parent;
			System.out.println("Casting 성공");
		}else {
			System.out.println("Casting 실패");
		}
	}
	
	public static void main(String[] args) {
		Parent p1 = new Child02();
		
//		Child child = (Child02)p1;
//		child.emtohd1
		method1(p1);
	}
}
