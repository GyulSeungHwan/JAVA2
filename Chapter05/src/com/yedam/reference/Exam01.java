package com.yedam.reference;

public class Exam01 {
	public static void main(String[] args) {
		//stack영역에 intVal이 생성되어 10이라는 데이터가 저장
		int intVal = 10;
		
		//참조타입
		//stack영역에 array가 생성(참조:[I@182decdb)되고
		//다음과 같은 주소가 저장 되어있다.
		int[] array = {1, 2, 3, 4, 5, 6};
		int[] array2 = {1, 2, 3, 4, 5, 6};
		int[] array3 = null;
		
		System.out.println(array);
		System.out.println(array2);
		System.out.println(array == array2);
		System.out.println(array3.length);
		//array3은 NullPointerException이 나온다
		//(null은 길이를 알 수 없기 때문에)
	}
}
