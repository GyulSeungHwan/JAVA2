package com.yedam.oop;

public class Application04 {
	
	static int a = 1;//밑에서 a를 사용하려고 앞에 static을 넣어줬다
	
	static void info() {
		System.out.println("info 출력");
	}//밑에서 info를 사용하려고 앞에 static을 넣어줬다
	
	int field1;
	
	//메소드 영역에 포함되어 있는 정적 메소드, main문
	public static void main(String[] args) {
		System.out.println(a);
		//위에 있는 a를 인식하지 못해서 오류가 난다
		
		info();
		//위에 있는 info를 인식하지 못해서 오류가 난다
		
		Application04 temp = new Application04();
		temp.field1 = 1;
		
		System.out.println(StaticCal.PI);
		System.out.println(StaticCal.earthRadius);
		
		int result = StaticCal.plus(10, 20);
		StaticCal cal = new StaticCal();
	}
}
