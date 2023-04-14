package com.yedam.time;

import java.util.List;
import java.util.Scanner;

import com.yedam.customer.Customer;
import com.yedam.customer.CustomerDAO;
import com.yedam.customer.CustomerService;

public class TimeService {
	
	public static Time timeInfo = null;
	Scanner sc = new Scanner(System.in);
	
	//시간제 전체 조회
	public void getTimeList() {
		List<Time> list = TimeDAO.getInstance().getTimeList();
		for(int i = 0; i<list.size(); i++) {
			System.out.println("시간제 종류 " + list.get(i).getTimeName() + "시간");
			System.out.println("시간제 가격 " + list.get(i).getTimePrice());
			System.out.println("▶▷▶▷▶▷▶▷▶▷▶▷▶▷▶▷▶▷▶▷▶▷▶▷▶▷▶▷▶▷▶▷▶▷▶▷");
		}
	}
	
	//시간제 등록
	public void insertTime() {
		System.out.println("시간제 등록>");
		int timeName = Integer.parseInt(sc.nextLine());
		System.out.println("시간제 가격");
		int menuPrice = Integer.parseInt(sc.nextLine());
		
		Time time = new Time();
		
		time.setTimeName(timeName);
		time.setTimePrice(menuPrice);
		time.setTimeSales(0);
		
		int result = TimeDAO.getInstance().insertTime(time);
		
		if(result == 1) {
			System.out.println("시간제 등록이 완료되었습니다.");
		}else {
			System.out.println("시간제 등록이 되지않았습니다.");
		}
	}
	
	//시간제 삭제
	public void timeDelete() {
		String time = null;
		System.out.println("삭제할 시간제 입력>");
		time = sc.nextLine();
		
		int result = TimeDAO.getInstance().timeDelete(time);
		
		if(result > 0) {
			System.out.println("시간제를 삭제하였습니다.");
		}else {
			System.out.println("시간제를 삭제하지 못했습니다.");
		}
	}
	
	//시간제 구매
	public void salesTime() {
		Time time = new Time();
		int Pt = 0;
		int salesCount = 0;
		double Tp = 0;
		
		System.out.println("구매할 시간제>");
		Pt = Integer.parseInt(sc.nextLine());
		System.out.println("구매할 수량");
		salesCount = Integer.parseInt(sc.nextLine());
		
		Time time2 = TimeDAO.getInstance().getTime(Pt);
		
		time.setTimeName(Pt);
		time.setTimeSales(salesCount);
		
		int result = TimeDAO.getInstance().salesTime(time);
		int result2 = TimeDAO.getInstance().startTime(time2.getTimeName()*60*60);
		
		if(result2 > 0) {
			System.out.println(time2.getTimeName()*salesCount + "시간이 충전되었습니다.");
			Customer customer = CustomerDAO.getInstance().login(CustomerService.customerInfo.getCustomerId());
			CustomerService.customerInfo=customer;
		}else {
			System.out.println("시간 충전이 되지않았습니다.");
		}
		
		if(result >= 1) {
			Tp = (double) (time2.getTimePrice()*salesCount)*0.001;
//			System.out.println(Tp);
//			System.out.println(Pt*salesCount + "시간이 충전되었습니다.");
//			CustomerDAO.getInstance().getPoints(Tp);
			int result3 = CustomerDAO.getInstance().getPoints(Tp);
			if(result3 > 0) {
				System.out.println(Tp + "포인트가 쌓였습니다.");
			}else {
				System.out.println("포인트가 쌓이지 않았습니다.");
			}
		}else {
			System.out.println("시간제를 구매하지 못했습니다.");
		}
	}
	
}
