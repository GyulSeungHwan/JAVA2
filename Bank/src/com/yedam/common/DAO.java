package com.yedam.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

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
	Properties pro = new Properties();
	String driver = "";
	String url = "";
	String id = "";
	String pw = "";
	//localhost -> 접속할 아이디
	//1521 -> PORT(DB서버에 들어가기 위해 가진 값)
	//xe -> SID
	
	//DB 연결
	public void conn() {
		getProperties();
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
	
	//DB 접속 정보 호출 메소드
	private void getProperties() {
		try {
			FileReader resource = new FileReader("src/config/db.properties");
			pro.load(resource);
			
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			id = pro.getProperty("id");
			pw = pro.getProperty("pw");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
