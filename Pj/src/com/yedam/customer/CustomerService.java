package com.yedam.customer;

import java.util.List;
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
	
	//전체 조회
	public void getCustomerList() {
		List<Customer> list = CustomerDAO.getInstance().getCustomerList();
		for(int i = 0; i<list.size(); i++) {
			System.out.println("아이디 : " + list.get(i).getCustomerId());
			System.out.println("비밀번호 : " + list.get(i).getCustomerPw());
			System.out.println("이름 : " + list.get(i).getCustomerName());
			System.out.println("이메일 : " + list.get(i).getCustomerEmail());
			System.out.println("주소 : " + list.get(i).getCustomerAdd());
			System.out.println("전화번호 : " + list.get(i).getCustomerNum());
			System.out.println("==============================================");
				
		}
	}
	
	//단건 조회
	public void getCustomer() {
		System.out.println("조회할 회원 아이디>");
		int id = Integer.parseInt(sc.nextLine());
		
		Customer customer = CustomerDAO.getInstance().getCustomer(id);
		
		if(customer == null) {
			System.out.println("등록되지 않은 회원입니다.");
		}else {
			System.out.println("회원 아이디 : " + customer.getCustomerId());
			System.out.println("회원 비밀번호 : " + customer.getCustomerPw());
			System.out.println("회원 이름 : " + customer.getCustomerName());
			System.out.println("회원 이메일 : " + customer.getCustomerEmail());
			System.out.println("회원 주소 : " + customer.getCustomerAdd());
			System.out.println("회원 전화번호 : " + customer.getCustomerNum());
			
		}
	}
	
	//회원 등록
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
	
	//회원 수정
	public void customerUpdate() {
		Customer customer = new Customer();
		System.out.println("아이디>");
		customer.setCustomerId(Integer.parseInt(sc.nextLine()));
		System.out.println("변경할 비밀번호>");
		customer.setCustomerPw(Integer.parseInt(sc.nextLine()));
		System.out.println("변경할 이메일 주소>");
		customer.setCustomerEmail(sc.nextLine());
		int result = CustomerDAO.getInstance().customerUpdate(customer);
		
		if(result > 0) {
			System.out.println("회원 정보가 수정되었습니다.");
		}else {
			System.out.println("회원 정보를 수정하지 못했습니다.");
		}
	}
	
	//회원 삭제
	public void customerDelete() {
		int customer = 0;
		System.out.println("삭제할 아이디>");
		customer = Integer.parseInt(sc.nextLine());
		
		int result = CustomerDAO.getInstance().customerDelete(customer);
		
		if(result > 0) {
			System.out.println("회원 정보를 삭제하였습니다.");
		}else {
			System.out.println("회원 정보를 삭제하지 못했습니다.");
		}
	}
	
}
