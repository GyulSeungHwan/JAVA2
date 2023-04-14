package com.yedam.customer;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import com.yedam.menu.Menu;
import com.yedam.menu.MenuDAO;
import com.yedam.time.Time;
import com.yedam.time.TimeDAO;
import com.yedam.time.TimeService;


public class CustomerService {
	public static long time = 0;
	public static Customer customerInfo = null;
	TimeService ts = new TimeService();
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
				Date start = new Date();
				long startTime = TimeUnit.MILLISECONDS.toSeconds(start.getTime());
				CustomerService.time = startTime;
			}else {
				System.out.println("비밀번호가 맞지않습니다.");
			}
		}else {
			System.out.println("아이디가 맞지않습니다.");
		}
		
	}
	
	public void logout() {
		if(customerInfo != null) {
			while(true) {
				Date now = new Date();
				long nowTime = TimeUnit.MILLISECONDS.toSeconds(now.getTime());
				long useTime = (nowTime - CustomerService.time);
				if((CustomerService.customerInfo.getStartTime()*60) - useTime < 0 && CustomerService.customerInfo.getCustomerGrade().equals("B")) {
					System.out.println("후불제로 변경되어 로그아웃 되지않습니다. \n시간을 구매해주세요.");
					ts.getTimeList();
					ts.salesTime();
				}else {
					TimeDAO.getInstance().startTime(-Math.ceil((useTime)));
					customerInfo = null;
					System.out.println("로그아웃되었습니다.");
					break;
				}
			}
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
			System.out.println("포인트 : " + list.get(i).getCustomerPoint());
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
			System.out.println("남은 시간 : " + customer.getStartTime()/60 + "분");
			System.out.println("포인트 : " + customer.getCustomerPoint());
			
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
//		CUSTOMER_GRADE          CHAR(1)\
		
		int customerId = 0;
		while(true) {
			System.out.println("아이디>");
			customerId = Integer.parseInt(sc.nextLine());
			
			if(CustomerDAO.getInstance().login(customerId)!=null) {
				System.out.println("이미 있는 회원입니다");
			}else {
				break;
			}
		}
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
		
		int result = CustomerDAO.getInstance().customerAdd(customer);
		if(result == 1) {
			System.out.println("회원이 등록되었습니다.");
		}else {
			System.out.println("회원을 등록하지 못했습니다.");
		}
		
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
	
	//내 정보 조회
	public void getCustomer2() {
		List<Customer> list = CustomerDAO.getInstance().getCustomerList();
		Date now = new Date();
		long nowTime = TimeUnit.MILLISECONDS.toSeconds(now.getTime());
		long useTime = (nowTime - CustomerService.time);
		for(Customer customer : list) {
			if(CustomerService.customerInfo.getCustomerId() == customer.getCustomerId()) {
				System.out.println("아이디 : " + customer.getCustomerId());
				System.out.println("비밀번호 : " + customer.getCustomerPw());
				System.out.println("이름 : " + customer.getCustomerName());
				System.out.println("이메일 : " + customer.getCustomerEmail());
				System.out.println("주소 : " + customer.getCustomerAdd());
				System.out.println("전화번호 : " + customer.getCustomerNum());
				System.out.println("남은 시간(초) : " + ((customer.getStartTime()) - useTime));
				System.out.println("포인트 : " + customer.getCustomerPoint());
			}
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
			System.out.println("시간제 : " + time.getTimeName());
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
