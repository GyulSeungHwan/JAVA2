package com.yedam.seller;

import com.yedam.common.DAO;

public class SellerDAO extends DAO {
	
	private static SellerDAO sellerDao = null;
	
	private SellerDAO() {
		
	}
	
	public static SellerDAO getInstance() {
		if(sellerDao == null) {
			sellerDao = new SellerDAO();
		}
		return sellerDao;
	}
	
	//내 정보 조회
	public Seller getSeller(int id) {
		Seller seller = null;
		try {
			conn();
			String sql = "SELECT * FROM seller WHERE customer_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				seller = new Seller();
				seller.setCustomerId(rs.getInt("customer_id"));
				seller.setTimeName(rs.getInt("time_name"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return seller;
	}
	
	
}
