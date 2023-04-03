package com.yedam.loop;

import java.util.Scanner;

public class WhileExample01 {

	public static void main(String[] args) {
		//1 ~ 100사이에서 2의 배수만 출력
		int i = 1;
		while(i<=100) {
			if(i%2 == 0) {
				System.out.println(i);
			}
			i++;
		}
		
		int menuNo = 0;
		Scanner sc = new Scanner(System.in);
		while(menuNo != 4) {
			System.out.println("1. 덧셈 | 2. 뺄셈 | 3. 곱셈 | 4. 종료");
			System.out.println("메뉴선택>");
			// 1 ~ 4
			menuNo = sc.nextInt();
			switch(menuNo){
			case 1:
				System.out.println("덧셈 실행");
				break;
			case 2:
				System.out.println("뺄셈 진행");
				break;
			case 3:
				System.out.println("곱셈 실행");
				break;
			case 4:
				System.out.println("프로그램 종료");
				break;
			}
		}
		
		//오락실
		int money;
		int menu = 0;
		System.out.println("=====Insert Coin=====");
		money = sc.nextInt();
		//1)게임 1회 실행 시 금액 500원 차감
		//2)내가 투입한 금액만큼만 반복문을 돌린다. 금액이 게임을 할 수 없는 금액이면,
		//반복문 종료,,, 3번 눌러서도 종료가 가능하다.
		//3)게임의 기회가 몇번 남았는지 표시하는 기능
		//ex) 1500원 -> 3번의 기회가 남아있습니다.
		//while(menu != 3) {
		//2000, 0/500 = 0
		while(money/500>0) {
			
			System.out.println((money/500) + "번의 기회가 있습니다");
			
			System.out.println("1. 가위바위보 | 2. 앞 뒤 맞추기 | 3. 종료");
			System.out.println("입력>");
			menu = sc.nextInt();
			
			if(menu == 1) {
				System.out.println("가위바위보");
				money -= 500;
			}else if(menu == 2) {
				System.out.println("앞 뒤 맞추기");
				money -= 500;
			}else if(menu == 3) {
				System.out.println("오락실 종료");
				break;
			}else {
				System.out.println("없는 메뉴입니다.");
			}
		}
		
		int month;
		do {
			System.out.println("올바른 월을 입력하세요[1-12]");
			month = sc.nextInt();
		}while(month<1 || month>12);
		
		//break, continue
		//무한 루프 -> 항상 true -> 항상 조건 만족 -> 반복문이 계속 실행
		while(true) {
			int num = (int)(Math.random() * 6) + 1;
			if(num == 6) {
				System.out.println("while 종료");
				break; //반복문 탈출
			}
		}
		
		System.out.println("브레이크 안 쓸 경우");
		
		//중첩 for문 안에서의 break;
		for(int j = 0; j<=10; j++) {
			for(int k=0; k<=10; k++) {
				if(j+k == 4)
					System.out.println("j + k = " + (j+k));
					break;
			}
		}
		
		Outter : for(char upper = 'A'; upper <= 'Z'; upper++) {
			for(char lower = 'a'; lower <= 'z'; lower++) {
				System.out.println(upper + "-" + lower);
				if(lower == 'g') {
					break Outter;
				}
			}
		}
		
		//continue
		//continue를 기준으로 반복문 재 실행
		for(int j = 0; j<=10; j++) {
			if(j%2 == 0) {
				continue;
			}
			System.out.println(j);
		}
	}
}