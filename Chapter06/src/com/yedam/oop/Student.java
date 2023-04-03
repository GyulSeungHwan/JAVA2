package com.yedam.oop;

public class Student {
	//학생이름, 학번, 국, 영, 수 점수를 가지는 학생
	String name;
	int num;
	int kor;
	int eng;
	int mat;
	//기본 생성자와 모든 데이터를 초기화 할 수 있다.
	Student(){
		
	}
	
	Student(String name, int num, int kor, int eng, int mat){
		this.name = name;
		this.num = num;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	int sum() {
		return kor + eng + mat;
	}
	double avg() {
		return (double)sum()/3;
	}
	void getInfo() {
		System.out.println("이름 : " + name);
		System.out.println("학번 : " + num);
		System.out.println("총점 : " + sum());
		System.out.println("평균 : " + avg());
	}
	//학생의 정보를 출력하는 getInfo()
	//1) 총점
	//2) 평균
	//getInfo 출력 결과
	//--------------------
	//이름 : 김또치
	//학번 : 20230330
	//총점 : 200
	//평균 : 68.xxxx
}