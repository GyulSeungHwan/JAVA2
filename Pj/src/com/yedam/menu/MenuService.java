package com.yedam.menu;

import java.util.List;
import java.util.Scanner;

public class MenuService {
	
	public static Menu menuInfo = null;
	Scanner sc = new Scanner(System.in);
	
	//메뉴 전체 조회
	public void getMenuList() {
		List<Menu> list = MenuDAO.getInstance().getMenuList();
		for(int i = 0; i<list.size(); i++) {
			System.out.println("음식 종류 : " + list.get(i).getMenuName());
			System.out.println("음식 가격 : " + list.get(i).getMenuPrice());
			System.out.println("판매 갯수 : " + list.get(i).getMenuSales());
			System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
		}
	}
	
	//메뉴 등록
	public void insertMenu() {
		System.out.println("음식 이름>");
		String menuName = sc.nextLine();
		System.out.println("음식 가격>");
		int menuPrice = Integer.parseInt(sc.nextLine());
		
		Menu menu = new Menu();
		
		menu.setMenuName(menuName);
		menu.setMenuPrice(menuPrice);
		menu.setMenuSales(0);
		
		int result = MenuDAO.getInstance().insertMenu(menu);
		
		if(result == 1) {
			System.out.println("메뉴 등록이 완료되었습니다.");
		}else {
			System.out.println("메뉴 등록이 되지않았습니다.");
		}
	}
	
	//메뉴 삭제
	public void menuDelete() {
		String menu = null;
		System.out.println("삭제할 메뉴 입력>");
		menu = sc.nextLine();
		
		int result = MenuDAO.getInstance().menuDelete(menu);
		
		if(result > 0) {
			System.out.println("메뉴를 삭제하였습니다.");
		}else {
			System.out.println("메뉴를 삭제하지 못했습니다.");
		}
	}
	
	//음식 구매
	public void salesMenu() {
		Menu menu = new Menu();
		String food = "";
		int salesCount = 0;
		
		System.out.println("구매할 메뉴>");
		food = sc.nextLine();
		System.out.println("구매할 수량>");
		salesCount = Integer.parseInt(sc.nextLine());
		
		menu.setMenuName(food);
		menu.setMenuSales(salesCount);
		
		int result = MenuDAO.getInstance().salesMenu(menu);
		
		if(result >= 1) {
			System.out.println(food + "\t" + salesCount + "개 구매 완료했습니다.");
		}else {
			System.out.println("구매하지 못했습니다.");
		}
	}
	
}
