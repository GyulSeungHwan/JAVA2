package com.yedam.exception;

public class ExceptionExam {
	public static void main(String[] args) {
		//NullPointException
//		String data = null;
//		System.out.println(data.toString());
		
//		Example example = null;
//		System.out.println(example.toString());
		
		//ArrayIndexOutOfBoundsException
		int[] intAry = new int[3];
		
		intAry[2] = 3;
//		intAry[4] = 3;
		//배열은 0, 1, 2, 3 까지인데 배열 4에 데이터를 넣어서 오류가 뜬다
		
//		for(int i=0; i<=intAry.length; i++) {
//			System.out.println(intAry[i]);
//		}
		
		//NumberFormatException
		String str = "123";
		int val = Integer.parseInt(str);
		System.out.println(val);
		
		//예외
		
		String str2 = "자바";
		val = Integer.parseInt(str2);
		System.out.println(str2);
		
		//ClassCastException
		//자동타입변환 된 객체를 강제타입변환할 때 발생
		//정상
		Example exam = new Exam();
		Exam exam02 = (Exam) exam;
		//예외
		Example exam2 = new Exam();
		Exam exam03 = (Exam02) exam2;
		
		//ClassNotFoundException -> Class 파일 찾지 못할 때
		//실행메소드(main) 못 찾을 때 자주 발생
		
		//ArithmeticException -> 분모가 0일때
		//double a = 1/0;
		
		//반복문을 종료하지 못하고 무한 루프 등등
		//OutofMemberError -> 메모리가 부족할 때
		//메모리 누수, memory leak
		
		//IOException -> 입출력 오류
		//file reading/write
		
		//FileNotFoundException
		//Java -> fild reading -> 경로가 맞지 않아서 파일을 못 찾았다
		
		
	}
}
