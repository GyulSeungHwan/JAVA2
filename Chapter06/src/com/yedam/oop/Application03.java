package com.yedam.oop;

public class Application03 {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		//메소드 호출
		cal.sum(10, 20);
		
		int result = cal.sum3(new int[] {1, 2, 3, 4, 5, 6, 76, 87, 9});
		System.out.println("sum3 : " + result);
		
		result = cal.sum4(1, 2, 3, 4, 5, 6, 7, 8, 9, 9);
		System.out.println("sum4 : " + result);
		
		Bycle bycle = new Bycle();
		bycle.setGas(5);
		
		boolean gasState = bycle.isLeftGas();
		
		if(gasState) {
			System.out.println("출발");
			bycle.run();
		}
		
		if(bycle.isLeftGas()) {
			System.out.println("gas 주입 필요 없음");
		}else {
			System.out.println("gas 주입 필요");
		}
		
		double result2 = cal.avg();
		
		System.out.println("평균 : " + result2);
		
		
		double result3 = cal.areaRectangle(10);
		
		double result4 = cal.areaRectangle(10, 20);
		
		System.out.println("정사각형의 넓이 : " + result3);
		System.out.println("직사각형의 넓이 : " + result4);
		
		// # 책 이름 : 혼자 공부하는 자바
		// # 내용
		// 1) 종료 : 학습서
		// 2) 가격 : 24000원
		// 3) 출판사 : 한빛 미디어
		// 4) 도서번호 : yedam001
		
		Book book1 = new Book("혼자 공부하는 자바", "학습서", 24000, "한빛 미디어", "yedam001");
		book1.getInfo();
		
		// # 책 이름 : HTML
		// # 내용
		// 1) 종료 : 학습서
		// 2) 가격 : 15000원
		// 3) 출판사 : 길벗
		// 4) 도서번호 : yedam001
		
		Book book2 = new Book("HTML", "학습서", 15000, "길벗", "yedam001");
		book2.getInfo();
		
		// # 책 이름 : JavaScript
		// # 내용
		// 1) 종료 : 학습서
		// 2) 가격 : 20000원
		// 3) 출판사 : 길벗
		// 4) 도서번호 : yedam001
		
		Book book3 = new Book("JavaScript", "학습서", 20000, "길벗", "yedam001");
		book3.getInfo();
		
		Student std = new Student("김또치", 1, 100, 20, 30);
		std.getInfo();
	}
}
