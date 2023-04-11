package com.yedam.seller;

import java.util.List;
import java.util.Scanner;

import com.yedam.customer.CustomerDAO;
import com.yedam.menu.Menu;
import com.yedam.menu.MenuDAO;
import com.yedam.time.Time;
import com.yedam.time.TimeDAO;

public class SellerService {
	
	Scanner sc = new Scanner(System.in);
	
	//내 정보 조회
	public void getSeller() {
		if(CustomerDAO.getInstance().getCustomer(1) == null) {
			System.out.println(CustomerDAO.getInstance().getCustomer(1));
		}
	}
	
	//매출
	public void pcSales() {
		System.out.println("===Kim's PC방 매출 내역===");
		
		List<Menu> list = MenuDAO.getInstance().getMenuList();
		List<Time> list2 = TimeDAO.getInstance().getTimeList();
		int totalSales = 0;
		int menuSales = 0;
		int timeSales = 0;
		System.out.println("####################################");
		for(Menu menu : list) {
			System.out.println("음식 이름 : " + menu.getMenuName());
			System.out.println("음식 가격 : " + menu.getMenuPrice());
			System.out.println("판매 수량 : " + menu.getMenuSales());
			System.out.println("판매 금액 : " + (menu.getMenuPrice()*
					menu.getMenuSales()) + "원");
			
			menuSales += (menu.getMenuPrice()*menu.getMenuSales());
			System.out.println("####################################");
		}
		System.out.println("음식 판매 금액 : " + menuSales + "원");
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		for(Time time : list2) {
			System.out.println("시간제 이름 : " + time.getTimeName());
			System.out.println("시간제 가격 : " + time.getTimePrice());
			System.out.println("판매 시간 : " + time.getTimeSales());
			System.out.println("판매 금액 : " + (time.getTimePrice()*
					time.getTimeSales()) + "원");
			
			timeSales += (time.getTimePrice()*time.getTimeSales());
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		}
		System.out.println("시간제 판매 금액 : " + timeSales + "원");
		
		totalSales = menuSales + timeSales;
		System.out.println("총 판매 금액 : " + totalSales + "원");
	}
	
}
