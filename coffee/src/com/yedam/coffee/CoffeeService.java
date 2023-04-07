package com.yedam.coffee;

import java.util.Scanner;

public class CoffeeService {
	public static Coffee coffeeInfo = null;
	Scanner sc = new Scanner(System.in);
	
	
	public void getCoffee() {
		Coffee coffee = CoffeeDAO.getInstance().getCoffee();
		System.out.println(coffee.toString());
	}
	
	
	
	
	
	public void coffeeAdd() {
		System.out.println("새로운 메뉴 입력>");
		String coffeeMenu = sc.nextLine();
		System.out.println("가격 입력>");
		int coffeePrice = Integer.parseInt(sc.nextLine());
		System.out.println("설명 입력>");
		String coffeeExplain = sc.nextLine();
		
		Coffee coffee = new Coffee();
		coffee.setCoffeeMenu(coffeeMenu);
		coffee.setCoffeePrice(coffeePrice);
		coffee.setCoffeeExplain(coffeeExplain);
		
		int result = CoffeeDAO.getInstance().coffeeAdd(coffee);
		
		if(result == 1) {
			System.out.println("메뉴 등록 완료");
		}else {
			System.out.println("메뉴 등록 실패");
		}
		
	}
	
	
	
	public void coffeeDelete() {
		System.out.println("삭제할 메뉴 입력>");
		String coffeeMenu = sc.nextLine();
		
		int result = CoffeeDAO.getInstance().coffeeDelete(coffeeMenu);
		
		if(result > 0) {
			System.out.println("메뉴 삭제 완료");
		}else {
			System.out.println("메뉴 삭제 실패");
		}
		
	}
	
	
}
