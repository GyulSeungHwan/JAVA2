package com.yedam.oop;

public class Book {
	//book이라는 클래스는 아래의 정보를 가집니다.
	//책 이름, 책 종류, 가격, 도서번호, 출판사
	//필드
	String name;
	String type;
	int price;
	String num;
	String pub;
	//생성자는 3개정도 생성
	
	//1) 기본 생성자
	public Book() {
		
	}
	//2) 모든 데이터를 초기화할 수 있는 생성자
	Book(String name, String type, int price, String num, String pub){
		this.name = name;
		this.type = type;
		this.price = price;
		this.num = num;
		this.pub = pub;
	}
	//3) 책 이름, 가격, 도서번호를 받아오는 생성자
	Book(String name, int price, String num){
		this.name = name;
		this.price = price;
		this.num = num;
	}
	//메소드는 getInfo() 메소드 가짐
	void getInfo() {
		System.out.println("# 책 이름 : " + name);
		System.out.println("# 내용");
		System.out.println("1) 종류 : " + type);
		System.out.println("2) 가격 : " + price);
		System.out.println("3) 출판사 : " + pub);
		System.out.println("4) 도서번호 : " + num);
	}
	//getInfo() 메소드를 클래스 외부에서 실행하였을때,
	//다음과 같은 출력물이 나오도록 구현
	//객체.getInfo()
	// # 책 이름 : 혼자 공부하는 자바
	// # 내용
	// 1) 종료 : 학습서
	// 2) 가격 : 24000원
	// 3) 출판사 : 한빛 미디어
	// 4) 도서번호 : yedam001
	
	// # 책 이름 : HTML
	// # 내용
	// 1) 종료 : 학습서
	// 2) 가격 : 15000원
	// 3) 출판사 : 길벗
	// 4) 도서번호 : yedam001
	
	// # 책 이름 : JavaScript
	// # 내용
	// 1) 종료 : 학습서
	// 2) 가격 : 20000원
	// 3) 출판사 : 길벗
	// 4) 도서번호 : yedam001
}
