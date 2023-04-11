package com.yedam.app;

import java.util.Scanner;

import com.yedam.customer.CustomerService;
import com.yedam.menu.MenuService;
import com.yedam.seller.SellerService;
import com.yedam.time.TimeService;

public class ManageMent {
	
	Scanner sc = new Scanner(System.in);
	int menu = 0;
	int menu2 = 0;
	int menu3 = 0;
	CustomerService cs = new CustomerService();
	MenuService ms = new MenuService();
	TimeService ts = new TimeService();
	SellerService ss = new SellerService();
	public ManageMent() {
		PcBang();
	}
	
	
	public void PcBang() {
		while(true) {
			menu();
			if(CustomerService.customerInfo.getCustomerGrade().equals("A")) {
				if(menu == 1) {
					cs.getCustomerList();
				}else if(menu == 2) {
					cs.getCustomer();
				}else if(menu == 3) {
					cs.customerAdd();
				}else if(menu == 4) {
					cs.customerUpdate();
				}else if(menu == 5) {
					cs.customerDelete();
				}else if(menu == 6) {
					while(true) {
						menu2();
						if(menu2 == 1) {
							ms.getMenuList();
						}else if(menu2 == 2) {
							ms.insertMenu();
						}else if(menu2 == 3) {
							ms.menuDelete();
						}
					}
				}else if(menu == 7) {
					while(true) {
						menu3();
						if(menu3 == 1) {
							ts.getTimeList();
						}else if(menu3 == 2) {
							ts.insertTime();
						}else if(menu3 == 3) {
							ts.timeDelete();
						}	
					}
				}else if(menu == 8) {
					ss.pcSales();
				}else if(menu == 99) {
					cs.logout();
					break;
				}
			}else if(CustomerService.customerInfo.getCustomerGrade().equals("B")) {
				if(menu == 1) {
					ss.getSeller();
				}else if(menu == 2) {
					ms.getMenuList();
				}else if(menu == 3) {
					ms.salesMenu();
				}else if(menu == 4) {
					ts.getTimeList();
				}else if(menu == 5) {
					ts.salesTime();
				}else if(menu == 99) {
					cs.logout();
					break;
				}
			}
		}
	}
	
	private void menu() {
		if(CustomerService.customerInfo.getCustomerGrade().equals("A")) {
			System.out.println("1.회원 전체 조회 | 2.회원 조회 | 3.회원 등록 | 4.회원 수정 | 5.회원 삭제 | 6.메뉴 목록 | 7.시간제 목록 | 8.매출 | 99.로그아웃");
		}else if(CustomerService.customerInfo.getCustomerGrade().equals("B")) {
			System.out.println("1.내 정보 조회 | 2.메뉴 조회 | 3.메뉴 구매 | 4.시간 조회 | 5.시간 구매 | 99.로그아웃");
		}
		System.out.println("입력>");
		menu = Integer.parseInt(sc.nextLine());
	}
	
	private void menu2() {
		if(CustomerService.customerInfo.getCustomerGrade().equals("A")) {
			System.out.println("1.메뉴 조회 | 2.메뉴 등록 | 3.메뉴 삭제");
			System.out.println("입력>");
			menu2 = Integer.parseInt(sc.nextLine());
		}else if(CustomerService.customerInfo.getCustomerGrade().equals("B")) {
			System.out.println("관리자가 아닙니다.");
		}
	}
	
	private void menu3() {
		if(CustomerService.customerInfo.getCustomerGrade().equals("A")) {
			System.out.println("1.시간제 조회 | 2.시간제 등록 | 3.시간제 삭제");
			System.out.println("입력>");
			menu3 = Integer.parseInt(sc.nextLine());
		}else if(CustomerService.customerInfo.getCustomerGrade().equals("B")) {
			System.out.println("관리자가 아닙니다.");
		}
	}
	
}
