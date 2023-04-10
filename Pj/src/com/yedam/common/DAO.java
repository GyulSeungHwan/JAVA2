package com.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {
	//DAO -> Data Access Object
	//JDBC
	//1) ojdbc를 추가
	//2) DAO
	
	//java -> DB 연결할 때 쓰는 객체
	protected Connection conn = null;
	
	//Select(조회) 결과값을 반환
	//Select한 결과를 Java로 전달
	protected ResultSet rs = null;
	
	//Query문을(Sql)을 가지고 실행하는 객체
	//1) sql문을 실행해주는 객체
	protected PreparedStatement pstmt = null;
	
	//2) sql문을 실행해주는 객체
	protected Statement stmt = null;
	
	//DB 접속 정보
	String driver = "oracle.jdbc.driver.OracleDriver";
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	//localhost -> 접속할 아이디
	//1521 -> PORT(DB서버에 들어가기 위해 가진 값)
	//xe -> SID
	String id = "pj";
	String pw = "pj";
	
	//DB 연결
	public void conn() {
		try {
			//1. 드라이버 로딩
			Class.forName(driver);
			//2. DB 연결
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//DB 연결 해제
	public void disconn() {
		try {
			//연결 -> select -> 결과
			//결과 조회 하는 객체
			if(rs != null) {
				rs.close();
			}
			//sql 실행하는 객체
			if(stmt != null) {
				stmt.close();
			}
			//db 연결 객체
			if(pstmt != null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
