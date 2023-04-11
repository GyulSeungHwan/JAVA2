package com.yedam.time;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class TimeDAO extends DAO {
	
	private static TimeDAO timeDao = null;
	
	private TimeDAO() {
		
	}
	
	public static TimeDAO getInstance() {
		if(timeDao == null) {
			timeDao = new TimeDAO();
		}
		return timeDao;
	}
	
	//시간제 전체 조회
	public List<Time> getTimeList(){
		List<Time> list = new ArrayList<>();
		
		Time time = null;
		
		try {
			conn();
			String sql = "SELECT * FROM time";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				time = new Time();
				time.setTimeName(rs.getInt("time_name"));
				time.setTimePrice(rs.getInt("time_price"));
				time.setTimeSales(rs.getInt("time_sales"));
				
				list.add(time);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//시간제 등록
	public int insertTime(Time time) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO time VALUES (?, ?, null)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, time.getTimeName());
			pstmt.setInt(2, time.getTimePrice());
			
			result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("시간제를 등록하였습니다.");
			}else {
				System.out.println("시간제가 등록되지 못했습니다.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//시간제 삭제
	public int timeDelete(String timeName) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM time WHERE time_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, timeName);
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//시간제 판매
	public int salesTime(Time time) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE time"
					+ " SET time_sales = time_sales + ?"
					+ " WHERE time_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, time.getTimeSales());
			pstmt.setInt(2, time.getTimeName());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
}
