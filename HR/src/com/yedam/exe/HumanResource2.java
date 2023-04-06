package com.yedam.exe;

import java.util.Scanner;

import com.yedam.departments.DepImpl;

public class HumanResource2 {
	
	DepImpl di = new DepImpl();
	Scanner sc = new Scanner(System.in);
	public HumanResource2() {
		run();
	}
	
	private void run() {
		while(true) {
			System.out.println("1.전체 조회 | 2.부서 정보 조회 | 3.부서 생성 | 4. 부서 수정 | 5.부서 삭제 | 99.종료");
			System.out.println("메뉴>");
			int menu = Integer.parseInt(sc.nextLine());
			if(menu == 1) {
				di.getDepartmentsList();
			}else if(menu == 99){
				System.out.println("종료");
				break;
			}
		}
	}
}
