package com.yedam.loop;

import java.util.Scanner;

public class homework20230328 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//문제1) 각 연산식을 대입 연산자 하나로 구성된 연산식을 수정하세요.
		int val = 0;
		
		//val = val + 10;
		val += 10;
		//val = val - 5;
		val -= 5;
		//val = val * 3;
		val *= 3;
		//val = val / 5;
		val /= 5;
		
		//문제2) 변수 val의 값이 양수일 경우엔 변수 값을, 아닐 경우엔 0을 담는 변수를 선언하세요. (단, 삼항연산자를 사용)
		System.out.println("값 입력>");
		int val2 = sc.nextInt();
		int intResult = val2;
		
		System.out.println((val2 > 0) ? intResult : 0);
		
		//문제3) 다음과 같이 두 개의 정수가 주어졌을 경우
		//		두 정수 중에서 음수가 있다면 'One of a or b is negative number'를,
		//		만일 그렇지 않다면 'both a and b are zero or more'를 출력하도록 구현하세요.
//		int a = 10;
//		int b = -8;
//		String strResult;
//		System.out.println(strResult);
//		if(strResult < 0) {
//			System.out.println("One of a or b is negative number");
//		}else {
//			System.out.println("both a and b are zero or more");
//		}
		
		//문제4) 차례대로 x와 y의 값이 주어졌을 때 어느 사분면에 해당되는지 출력하도록 구현하세요.
		//각 사분면에 해당하는 x와 y의 값은 아래를 참조하세요.
		//제 1사분면 : x>0, y>0
		//제 2사분면 : x<0, y>0
		//제 3사분면 : x<0, y<0
		//제 4사분면 : x>0, y<0
		//문제출처, 백준(https://www.acmicpc.net/) 14681번 문제
		
		System.out.println("x의 값을 입력하세요>");
		int x = sc.nextInt();
		System.out.println("y의 값을 입력하세요>");
		int y = sc.nextInt();
		if(x > 0 && y > 0) {
			System.out.println("제 1사분면입니다.");
		}else if(x < 0 && y > 0) {
			System.out.println("제 2사분면입니다.");
		}else if(x < 0 && y < 0) {
			System.out.println("제 3사분면입니다.");
		}else if(x > 0 && y < 0) {
			System.out.println("제 4사분면입니다.");
		}
		
		//문제5) 연도가 주어졌을 때 해당 년도가 윤년인지를 확인해서 출력하도록 하세요.
		//윤년은 연도가 4의 배수이면서 100의 배수가 아닐 때 또는 400의 배수일 때입니다.
		//예를 들어, 2012년은 4의 배수이면서 100의 배수가 아니라서 윤년이며,
		//1900년은 100의 배수이고 400의 배수는 아니기 때문에 윤년이 아닙니다.
		//HinT : 이중 IF문 사용
		//문제출처, 백준(https://www.acmicpc.net/) 2753번 문제
		
		System.out.println("연도를 입력하세요>");
		int year = sc.nextInt();
		if(year%4 == 0 && year%100 != 0 || year%400 == 0) {
			System.out.println("윤년입니다.");
		}else {
			System.out.println("윤년이 아닙니다.");
		}
		
		//문제6) switch문을 이용하여 가위, 바위, 보 중 하나가 주어졌을 때
		//사용자 어떤 값을 가져야 이길 수 있는 지를 출력하도록 구현하세요.
		//예를 들어, 가위가 주어졌을 때 "이기기 위해선 바위를 내야합니다." 라고 출력하도록 하세요.
		//한 단어를 입력받을 경우 Scanner객체의 next() 함수를 사용하면 됩니다.
		
		System.out.println("가위, 바위, 보, 중에 입력하세요>");
		String rock = sc.next();
		switch(rock) {
		case "가위":
			System.out.println("이기기 위해선 바위를 내야합니다.");
			break;
		case "바위":
			System.out.println("이기기 위해선 보를 내야합니다.");
			break;
		case "보":
			System.out.println("이기기 위해선 가위를 내야합니다.");
			break;
		default:
			System.out.println("가위, 바위, 보 중에 내야합니다.");
		}
	}
}
