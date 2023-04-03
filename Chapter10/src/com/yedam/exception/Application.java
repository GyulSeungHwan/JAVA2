package com.yedam.exception;

public class Application {
	public static void main(String[] args) {
//		try {
//			//예외가 발생할꺼 같은 실행코드
//		}catch(예외) {
//			//예외가 발생 후 처리하는 코드
//		}finally {
//			//옵션
//			//try 문 또는 catch문 실행하고 나서
//			//무.조.건 실행해야하는 코드
//		}
		String data1 = null;
		String data2 = null;
		try {
//			data1 = args[0]; //배열 범위를 벗어남
//			data2 = args[1]; //배열 범위를 벗어남
			
//			double avg = 1/0;
			
//			String str = "자바";
//			int a = Integer.parseInt(str);
			
//			Class calzz = Class.forName("java.lang.String2");
			
		}catch(ArrayIndexOutOfBoundsException e) {
			//배열 범위를 벗어날걸 알고 짠 코드여서 밑의 출력이 나온다
			System.out.println("실행 매개값의 수가 부족합니다.");
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}catch(NumberFormatException e) {
			System.out.println("문자열 변환 에러");
		}catch(ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없다.");
		}catch(Exception e) {
			System.out.println("위에서 처리 못하면 내가 처리한다.");
		}finally {
			System.out.println("finally 항상 실행");
		}
	}
}
