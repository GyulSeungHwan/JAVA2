package com.yedam.array;

import java.util.Scanner;

public class Exam06 {
	public static void main(String[] args) {
		//p.201 6번 문제
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("-------------------------------------------------");
			System.out.println("선택> ");
			
			int selectNo = Integer.parseInt(sc.nextLine());
			
			if(selectNo == 1) {
				System.out.println("학생수>");
				studentNum = Integer.parseInt(sc.nextLine());
				//배열 크기 설정
				scores = new int[studentNum];
			}else if(selectNo == 2) {
				for(int i = 0; i<scores.length; i++) {
					scores[i] = Integer.parseInt(sc.nextLine());
				}
			}else if(selectNo == 3) {
				for(int i = 0; i<scores.length; i++) {
					System.out.println("scores["+i+"]>" + scores[i]);
				}
			}else if(selectNo == 4) {
				int sum = 0;
				for(int i = 0; i<scores.length; i++) {
					sum += scores[i];
				}
				System.out.println("총합 : " + sum);
				System.out.println("평균 : " + (double)sum/studentNum);
			}else if(selectNo == 5) {
				run = false;
			}
		}
		
		System.out.println("프로그램 종료");
	}
}
