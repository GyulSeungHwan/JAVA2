package com.yedam.time;

import java.util.List;
import java.util.Scanner;

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
		
//		if(result == 1) {
//			System.out.println("시간제 등록이 완료되었습니다.");
//		}else {
//			System.out.println("시간제 등록이 되지않았습니다.");
//		}
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
	
	//시간제 판매
	public void salesTime() {
		Time time = new Time();
		int Pt = 0;
		int salesCount = 0;
		
		System.out.println("구매할 시간제>");
		Pt = Integer.parseInt(sc.nextLine());
		System.out.println("구매할 수량");
		salesCount = Integer.parseInt(sc.nextLine());
		
		time.setTimeName(Pt);
		time.setTimeSales(salesCount);
		
		int result = TimeDAO.getInstance().salesTime(time);
		
		if(result >= 1) {
			System.out.println(Pt + "\t" + salesCount + " 건 구매 완료했습니다.");
		}else {
			System.out.println("구매하지 못했습니다.");
		}
	}
	
}
