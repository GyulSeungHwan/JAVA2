package com.yedam.customer;

import java.util.Scanner;

public class CustomerService {
	
	public static Customer customerInfo = null;
	Scanner sc = new Scanner(System.in);
	
	
	public void login() {
		Customer customer = new Customer();
		
		System.out.println("아이디>");
		int id = Integer.parseInt(sc.nextLine());
		
		System.out.println("비밀번호>");
		int pw = Integer.parseInt(sc.nextLine());
		
		customer = CustomerDAO.getInstance().login(id);
		
		if(customer != null) {
			if(pw == customer.getCustomerPw()) {
				System.out.println("로그인 성공");
				customerInfo = customer;
			}else {
				System.out.println("비밀번호가 맞지않습니다.");
			}
		}else {
			System.out.println("아이디가 맞지않습니다.");
		}
		
	}
	
	public void logout() {
		if(customerInfo != null) {
			customerInfo = null;
			System.out.println("로그아웃되었습니다.");
		}
	}
	
	public void customerAdd() {
//		CUSTOMER_ID    NOT NULL NUMBER
//		CUSTOMER_PW    NOT NULL NUMBER
//		CUSTOMER_NAME  NOT NULL VARCHAR2(20)
//		CUSTOMER_EMAIL          VARCHAR2(30)
//		CUSTOMER_ADD            VARCHAR2(100)
//		CUSTOMER_NUM   NOT NULL VARCHAR2(20)
//		CUSTOMER_GRADE          CHAR(1)
		System.out.println("아이디>");
		int customerId = Integer.parseInt(sc.nextLine());
		System.out.println("비밀번호>");
		int customerPw = Integer.parseInt(sc.nextLine());
		System.out.println("이름>");
		String customerName = sc.nextLine();
		System.out.println("이메일>");
		String customerEmail = sc.nextLine();
		System.out.println("주소>");
		String customerAdd = sc.nextLine();
		System.out.println("전화번호>");
		String customerNum = sc.nextLine();
		
		Customer customer = new Customer();
		
		customer.setCustomerId(customerId);
		customer.setCustomerPw(customerPw);
		customer.setCustomerName(customerName);
		customer.setCustomerEmail(customerEmail);
		customer.setCustomerAdd(customerAdd);
		customer.setCustomerNum(customerNum);
		
		CustomerDAO.getInstance().customerAdd(customer);
		
		
		
	}
	
}
