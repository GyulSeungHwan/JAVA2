package com.yedam.app;

import java.util.Scanner;

import com.yedam.coffee.CoffeeService;

public class ManageMent {
	
	Scanner sc = new Scanner(System.in);
	int menu = 0;
	CoffeeService cs = new CoffeeService();
	
	
	public ManageMent() {
		cafe();
	}
	
	
	public void cafe() {
		while(true) {
			System.out.println("1.메뉴 조회 | 2.메뉴 상세 조회 | 3.메뉴 등록 | 4.판매 | 5.메뉴 삭제 | 6.매출 | 7.종료");
			System.out.println("메뉴 입력>");
			int menu = Integer.parseInt(sc.nextLine());
			if(menu == 1) {
				cs.getCoffee();
			}else if(menu == 2) {
				
			}else if(menu == 3) {
				cs.coffeeAdd();
			}else if(menu == 4) {
				
			}else if(menu == 5) {
				cs.coffeeDelete();
			}else if(menu == 6) {
				
			}else if(menu == 7) {
				System.out.println("end of prog");
				break;
			}
		}
	}
	
}
