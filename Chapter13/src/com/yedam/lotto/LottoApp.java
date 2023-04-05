package com.yedam.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoApp {
	
	private Scanner sc = new Scanner(System.in);
	int menu = 0;
	
	int[] lotto = new int[6];
	List<int[]> list = new ArrayList<>();
	
	public LottoApp() {
		run();
	}
	
	//메뉴 선택 로또 프로그램
	private void run() {
		while(menu != 99) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.println("1.로또 생성 2.로또 조회 99.프로그램 종료");
			menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1 :
				makeLotto();
				break;
			case 2 :
				showInfo();
				break;
			case 99 :
				System.out.println("프로그램 종료");
				break;
				
			}
			
		}
	}
	
	private void showInfo() {
		System.out.println("구매 한 금액>" + list.size() * 1000 + "원");
		for(int i=0; i<list.size(); i++) {
			System.out.println((i % 5 + 1) + "번>");
			for(int j=0; j<lotto.length; j++) {
				//list.get(i) = lotto
				//lotto[0], lotto[1], lotto[2], lotto[3].....
				System.out.print(list.get(i)[j] + " ");
			}
			
			System.out.println();
			
			if((i + 1) % 5 == 0) {
				System.out.println("-------------------------------------------");
			}
		}
	}
	
	private void makeLotto() {
		System.out.println("금액 투입>");
//		//1.입력한 금액만큼 로또번호 생성(1줄당 천원)
//		//예) 10,000원 -> 6개짜리 번호가 10개
//		//list에 저장
		int money = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i<(money/1000); i++) {
			makeNumber();
			list.add(lotto);
//			=list.add(makeNumber());
		}
	}
//	public LottoApp() {
//		makeNumber();
//	}
	
	private void makeNumber() {
		//로또 번호 6개 만드는거
		//단, 중복은 발생하면 안된다
		//정렬 안해도 된다
		//잘 되었는지 출력
		int[] lotto = new int[6];
		for(int i=0; i<6; i++) {
			//랜덤 데이터 뽑기(배열에 데이터 저장)
			lotto[i] = (int)(Math.random() * 45) +1;
			//인덱스가 0일때 중복 체크 할 필요가 없다
			if (i>0) {
				//인덱스가 1이상일때 중복 체크
				for(int j=0; j<i; j++) {
					//방금 생성한 랜덤값과 내가 가지고 있는 값과 같으면...
					if(lotto[i] == lotto[j]) {
						//다시 i값 -1(다시 랜덤값 생성)
						i -= 1;
						break;
					}
				}
			}
		}
//		for(int i=0; i<lotto.length; i++) {
//			System.out.println(lotto[i]);
//		}
	}
}
