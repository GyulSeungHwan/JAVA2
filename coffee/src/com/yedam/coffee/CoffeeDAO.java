package com.yedam.coffee;

import com.yedam.common.DAO;

public class CoffeeDAO extends DAO {
	
	private static CoffeeDAO coffeeDao = new CoffeeDAO();
	
	private CoffeeDAO() {
		
	}
	
	public static CoffeeDAO getInstance() {
		return coffeeDao;
	}
	
	public Coffee getCoffee() {
		Coffee coffee = null;
		try {
			conn();
			
			String sql = "SELECT * FROM coffee";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				coffee = new Coffee();
				coffee.setCoffeeMenu(rs.getString("menu"));
				coffee.setCoffeePrice(rs.getInt("price"));
				coffee.setCoffeeExplain(rs.getString("explain"));
				coffee.setCoffeeSales(rs.getInt("sales"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return coffee;
	}
	
//	public Coffee login(String menu) {
//		Coffee coffee = null;
//		try {
//			conn();
//			String sql = "SELECT * FROM coffee";
//			stmt = conn.createStatement();
//			
//			rs = stmt.executeQuery(sql);
//			
//			if(rs.next()) {
//				coffee = new Coffee();
//				coffee.setCoffeeMenu(rs.getString("menu"));
//				coffee.setCoffeePrice(rs.getInt("price"));
//				coffee.setCoffeeExplain(rs.getString("explain"));
//				coffee.setCoffeeSales(rs.getInt("sales"));
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			disconn();
//		}
//		
//		return coffee;
//		
//	}

	public int coffeeAdd(Coffee coffee) {
		int result = 0;
		try {
			conn();
			
			String sql = "INSERT INTO coffee VALUES (?, ?, ?, null)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, coffee.getCoffeeMenu());
			pstmt.setInt(2, coffee.getCoffeePrice());
			pstmt.setString(3, coffee.getCoffeeExplain());
			
			result = pstmt.executeUpdate();
			
			if(rs.next()) {
				coffee = new Coffee();
				coffee.setCoffeeMenu(rs.getString("coffee_menu"));
				coffee.setCoffeePrice(rs.getInt("coffee_price"));
				coffee.setCoffeeExplain(rs.getString("coffee_explain"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
	}

	public int coffeeDelete(String coffeeMenu) {
		int result = 0;
		try {
			conn();
			
			String sql = "DELETE FROM coffeeMenu WHERE coffee_menu = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, coffeeMenu);
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
	}

	
	
	
	
	
}
