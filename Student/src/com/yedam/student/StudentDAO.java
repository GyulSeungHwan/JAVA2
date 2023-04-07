package com.yedam.student;

import com.yedam.common.DAO;

public class StudentDAO extends DAO {
	
	private static StudentDAO studentDao = new StudentDAO();
	
	private StudentDAO() {
		
	}
	
	public static StudentDAO getInstance() {
		return studentDao;
	}
	
	public Student login(int id) {
		Student student = null;
		try {
			conn();
			String sql = "SELECT * FROM student WHERE student_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				student = new Student();
				student.setStudentId(rs.getInt("student_id"));
				student.setStudentName(rs.getString("student_name"));
				student.setStudentMajor(rs.getString("student_major"));
				student.setStudentScore(rs.getInt("student_score"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconn();
		}
		return student;
	}
	
	
}
