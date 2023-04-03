package test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int x = 10;
		double y = 2.0;
		System.out.println(x + (int)y);
		System.out.println((double)x + y);
		System.out.println(x - (int)y);
		System.out.println((double)x - y);
		System.out.println(x * (int)y);
		System.out.println((double)x * y);
		System.out.println(x / (int)y);
		System.out.println((double)x / y);
		
//		----------------------------------------------------------------------------------------
		
		int num1 = 10;
		int num2 = 20;
		boolean result;
		
		result = ((num1 > 10) && (num2 > 10));
		System.out.println(result);
		result = ((num1 > 10) || (num2 > 10));
		System.out.println(result);
		System.out.println(!result);
		
//		----------------------------------------------------------------------------------------
		
		//큰 금액부터 동전을 우선적으로 거슬러 줘야한다.
		int[] coinUnit = {500, 100, 50, 10};
		int money = 2680;
		System.out.println("money=" + money);
		for(int i=0; i<coinUnit.length; i++) {
			System.out.println(coinUnit[i] + "원 : " + money / coinUnit[i] + "개");
			money %= coinUnit[i];
		}
		
//		----------------------------------------------------------------------------------------
		
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=i; j++) {
				System.out.println(i + " * " + j + " = " + i*j);
			}
		}
		
//		----------------------------------------------------------------------------------------
		
		Scanner sc = new Scanner(System.in);
		int size = 0; //주사위 크기
		int[] dice = null;
		boolean run = true;
		
		while(run) {
			System.out.println("=== 1.주사위 크기 2.주사위 굴리기 3.결과 보기 4.가장 많이 나온 수 5.종료 ===");
			System.out.println("메뉴 >");
			String selectNo = sc.nextLine();
			
			switch(selectNo) {
			case "1":
				System.out.println("주사위 크기 >");
				size = Integer.parseInt(sc.nextLine());
				if(size < 5 || size > 10) {
					System.out.println("5 ~ 10 사이의 수를 입력하세요.");
					size = 0;
				}
				break;
			case "2":
				//주사위 크기 설정
				dice = new int[size];
				//몇 번 반복 했는지
				int count = 0;
				//5가 언제 나올지 모르기 때문에, while로 나올 때까지 반복문을 사용하기 위함
				while(true) {
					int random = (int)(Math.random() * size) + 1;
					System.out.println(random);
					//각 주사위 숫자 -> 배열 저장
					//주사위 숫자 1 2 3 4 5
					//배열 0 1 2 3 4 
					dice[random-1] = dice[random-1] + 1; //dice[random-1]++;
					count++;
					if(random == 5) {
					}
					break;
				}
				System.out.println("5가 나올 때까지 주사위를 " + count + "번 굴렸습니다.");
				//만약 주사위의 크기가 5보다 작고 10보다 크다면...?
//				if(size != 0) {
//					//주사위를 돌린다.
//				}else {
//					System.out.println("주사위 크기 재입력하세요.");
//				}
				break;
			case "3":
				for(int i=0; i<dice.length; i++) {
					System.out.println((i+1)+"은 " + dice[i] + "번 나왔습니다.");
				}
				break;
			case "4":
				int max = dice[0];
				int index = 0;
				for(int i=0; i<dice.length; i++) {
					if(max < dice[i]) {
						max = dice[i];
						index = i;
					}
				}
				System.out.println("가장 많이 나온 수는 " + (index+1) + "입니다.");
				break;
			case "5":
				System.out.println("프로그램 종료");
			}
			break;
		}
	}
}
