package com.yedam.menu;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class MenuDAO extends DAO {
	
	private static MenuDAO menuDao = null;
	
	private MenuDAO() {
		
	}
	
	public static MenuDAO getInstance() {
		if(menuDao == null) {
			menuDao = new MenuDAO();
		}
		return menuDao;
	}
	
	//메뉴 전체 조회
	public List<Menu> getMenuList() {
		List<Menu> list = new ArrayList<>();
		
		Menu menu = null;
		
		try {
			conn();
			String sql = "SELECT * FROM menu";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				menu = new Menu();
				menu.setMenuName(rs.getString("menu_name"));
				menu.setMenuPrice(rs.getInt("menu_price"));
				menu.setMenuSales(rs.getInt("menu_sales"));
				
				list.add(menu);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//메뉴 등록
	public int insertMenu(Menu menu) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO menu VALUES (?, ?, 0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu.getMenuName());
			pstmt.setInt(2, menu.getMenuPrice());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//메뉴 삭제
	public int menuDelete(String menuName) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM menu WHERE menu_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menuName);
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//음식 구매
	public int salesMenu(Menu menu) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE menu"
					+ " SET menu_sales = menu_sales + ?"
					+ " WHERE menu_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, menu.getMenuSales());
			pstmt.setString(2, menu.getMenuName());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//메뉴 이름의 가격을 가져오는 것
	public Menu getMenu(String food) {
		Menu menu = null;
		try {
			conn();
			String sql = "SELECT * FROM menu WHERE menu_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, food);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				menu = new Menu();
				menu.setMenuPrice(rs.getInt("menu_price"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return menu;
	}
	
}
