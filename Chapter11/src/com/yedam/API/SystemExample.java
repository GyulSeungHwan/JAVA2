package com.yedam.API;

public class SystemExample {
	public static void main(String[] args) {
		//System클래스
		//System.exit(0)
		
//		for(int i=0; i<=10; i++) {
//			System.out.println(i);
//			if(i==5) {
//				System.exit(0); //static으로 정의되어 있음
//				//prg 강제종료(최대한 쓰지말기)
//				//S -> Class는 static을 다 가져올 수 있다
//			}
//		}
//		System.out.println("프로그램 종료");
		
		//현재 시간 읽기
		long time = System.nanoTime(); //start
		
		int sum = 0;
		
		for(int i=0; i<=1000000; i++) {
			sum += i;
		}
		
		long time2 = System.nanoTime();
		
		System.out.println(time);
		System.out.println(time2);
		System.out.println("1~1000000의 합 : " + sum);
		System.out.println("소요 시간 : " + (time2-time) + "나노 초 소요");
		
		System.out.println(System.currentTimeMillis());
	}
}
