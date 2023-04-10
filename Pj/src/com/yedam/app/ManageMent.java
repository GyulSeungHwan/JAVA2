package com.yedam.app;

import java.util.Scanner;

import com.yedam.customer.CustomerService;

public class ManageMent {
	
	Scanner sc = new Scanner(System.in);
	int menu = 0;
	CustomerService cs = new CustomerService();
	
	public ManageMent() {
		PcBang();
	}
	
	
	public void PcBang() {
		while(true) {
			menu();
			if(CustomerService.customerInfo.getCustomerGrade().equals("A")) {
				if(menu == 1) {
					
				}else if(menu == 2) {
					
				}else if(menu == 3) {
					
				}else if(menu == 4) {
					
				}else if(menu == 5) {
					
				}else if(menu == 6) {
					
				}else if(menu == 7) {
					
				}else if(menu == 8) {
					
				}else if(menu == 9) {
					
				}else if(menu == 10) {
					
				}else if(menu == 11) {
					
				}else if(menu == 12) {
					
				}else if(menu == 13) {
					
				}else if(menu == 14) {
					
				}else if(menu == 99) {
					cs.logout();
					break;
				}
			}else if(CustomerService.customerInfo.getCustomerGrade().equals("B")) {
				if(menu == 1) {
					
				}else if(menu == 2) {
					
				}else if(menu == 3) {
					
				}else if(menu == 99) {
					cs.logout();
					break;
				}
				
				
				
				
			}
			
			
			
		}
	}
	
	private void menu() {
		if(CustomerService.customerInfo.getCustomerGrade().equals("A")) {
			System.out.println("1.회원 전체 조회 | 2.회원 조회 | 3.회원 등록 | 4.회원 수정 | 5.회원 삭제 | 6.메뉴 조회 | 7.메뉴 등록 | 8.메뉴 삭제 | 9.음식 판매 | 10.시간 조회 | 11.시간 등록 | 12.시간 삭제 | 13.시간 판매 | 14.매출 | 99.로그아웃");
		}else if(CustomerService.customerInfo.getCustomerGrade().equals("B")) {
			System.out.println("1.내 정보 조회 | 2.메뉴 조회 | 3.시간 조회 | 99.로그아웃");
		}
		System.out.println("입력>");
		menu = Integer.parseInt(sc.nextLine());
	}
	
	
	
}
