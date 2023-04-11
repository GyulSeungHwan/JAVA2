package com.yedam.customer;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class CustomerDAO extends DAO {
	
	private static CustomerDAO customerDao = null;
	
	private CustomerDAO() {
		
	}
	
	public static CustomerDAO getInstance() {
		if(customerDao == null) {
			customerDao = new CustomerDAO();
		}
		return customerDao;
	}
	
	//로그인
	public Customer login(int id) {
		Customer customer = null;
		try {
			conn();
			String sql = "SELECT * FROM customer WHERE customer_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getInt("customer_id"));
				customer.setCustomerPw(rs.getInt("customer_pw"));
				customer.setCustomerName(rs.getString("customer_name"));
				customer.setCustomerGrade(rs.getString("customer_grade"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return customer;
	}
	
	
	//회원 전체 조회
	public List<Customer> getCustomerList() {
		List<Customer> list = new ArrayList<>();
		
		Customer customer = null;
		
		try {
			conn();
			String sql = "SELECT * FROM customer";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getInt("customer_id"));
				customer.setCustomerPw(rs.getInt("customer_pw"));
				customer.setCustomerName(rs.getString("customer_name"));
				customer.setCustomerEmail(rs.getString("customer_email"));
				customer.setCustomerAdd(rs.getString("customer_add"));
				customer.setCustomerNum(rs.getString("customer_num"));
				customer.setCustomerGrade(rs.getString("customer_grade"));
				
				list.add(customer);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//회원 단건 조회
	public Customer getCustomer(int id) {
		Customer customer = null;
		try {
			conn();
			String sql = "SELECT * FROM customer WHERE customer_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getInt("customer_id"));
				customer.setCustomerPw(rs.getInt("customer_pw"));
				customer.setCustomerName(rs.getString("customer_name"));
				customer.setCustomerEmail(rs.getString("customer_email"));
				customer.setCustomerAdd(rs.getString("customer_add"));
				customer.setCustomerNum(rs.getString("customer_num"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return customer;
	}
	
	//회원 등록
	public int customerAdd(Customer customer) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?, 'B')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customer.getCustomerId());
			pstmt.setInt(2, customer.getCustomerPw());
			pstmt.setString(3, customer.getCustomerName());
			pstmt.setString(4, customer.getCustomerEmail());
			pstmt.setString(5, customer.getCustomerAdd());
			pstmt.setString(6, customer.getCustomerNum());
			
			result = pstmt.executeUpdate();
			
			if(getCustomerList() != null) {
				System.out.println("회원이 등록되었습니다.");
			}else {
				System.out.println("이미 있는 회원입니다.");
			}
			
//			if(result == 1) {
//				System.out.println("회원이 등록되었습니다.");
//			}else {
//				System.out.println("회원 등록을 하지못했습니다");
//			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//회원 수정
	public int customerUpdate(Customer customer) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE customer SET customer_pw = ?, customer_email = ? WHERE customer_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customer.getCustomerPw());
			pstmt.setString(2, customer.getCustomerEmail());
			pstmt.setInt(3, customer.getCustomerId());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//회원 삭제
	public int customerDelete(int customerId) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM customer WHERE customer_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customerId);
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
}
