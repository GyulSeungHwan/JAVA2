package com.yedam.app;

import java.util.Scanner;

import com.yedam.customer.CustomerService;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	CustomerService cs = new CustomerService();
	String menuNo = "";
	public Application() {
		run();
	}
	
	private void run() {
		while(true) {
			System.out.println("1.로그인 | 2.종료");
			menuNo = sc.nextLine();
			
			if(menuNo.equals("1")) {
				cs.login();
				if(CustomerService.customerInfo != null) {
					new ManageMent();
				}
			}else if(menuNo.equals("2")) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
}
