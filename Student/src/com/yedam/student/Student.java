package com.yedam.student;

import lombok.Data;

@Data
public class Student {
//	STUDENT_ID    NOT NULL NUMBER
//	STUDENT_NAME           VARCHAR2(15)
//	STUDENT_MAJOR          VARCHAR2(30)
//	STUDENT_SCORE          NUMBER
	
	private int studentId;
	private String StudentName;
	private String StudentMajor;
	private int StudentScore;
}
