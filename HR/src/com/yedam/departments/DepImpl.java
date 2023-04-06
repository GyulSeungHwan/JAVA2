package com.yedam.departments;

import java.util.List;
import java.util.Scanner;

public class DepImpl {
	Scanner sc = new Scanner(System.in);
	public void getDepartmentsList() {
		List<DepDTO> list = DepDAO.getInstance().getDepartmentsList();
		
		for(int i = 0; i<list.size(); i++) {
			System.out.println("부서번호 : " + list.get(i).getDepartmentId());
			System.out.println("부서이름 : " + list.get(i).getDepartmentName());
			System.out.println("관리자 : " + list.get(i).getManagerId());
			System.out.println("부서위치 : " + list.get(i).getLocationId());
		}
	}
}
