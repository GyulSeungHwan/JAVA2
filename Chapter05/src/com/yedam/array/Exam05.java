package com.yedam.array;

public class Exam05 {
	public static void main(String[] args) {
		//최대값과 최대값의 인덱스 구하기
		int[] array = {10, 50, 70, 20, 30, 80, 40};
		//1)최대값
		//2)최대값의 인덱스
		int max = array[0];
		int maxIndex = 0;
		
		for(int i = 0; i<array.length; i++) {
			if(max < array[i]) {
				max = array[i];
				maxIndex = i;
			}
		}
		System.out.println("최대값 : " + max + " 최대값의 위치 : " + maxIndex);
		
	}
}
