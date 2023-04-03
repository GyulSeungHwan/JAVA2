package com.yedam.array;

import java.util.Scanner;

public class Exam04 {
	public static void main(String[] args) {
		//배열에 담긴 최대, 최소값
		Scanner sc = new Scanner(System.in);
		
		int[] ary;
		int no;
		
		System.out.println("배열의 크기>");
		no = sc.nextInt();
		sc.nextLine();
		//nextInt에서 받은 데이터를 제외한 엔터키를 먹어준다
		ary = new int[no];
		
		//배열에 데이터 입력
		for(int i = 0; i<ary.length; i++) {
			System.out.println("데이터 입력>");
			ary[i] = Integer.parseInt(sc.nextLine());
		}
		
		//최대값 구하기
		int max = 0; //원래는 0이 아닌 ary[0]이 들어가야 된다
		for(int i = 0; i<ary.length; i++) {
			if(max < ary[i]) {
				max = ary[i];
			}
		}
		System.out.println("최대값 : " + max);
		
		//최소값 구하기
		int min = ary[0];
		for(int i = 0; i<ary.length; i++) {
			if(min > ary[i]) {
				min = ary[i];
			}
		}
		System.out.println("최소값 : " + min);
	}
}
