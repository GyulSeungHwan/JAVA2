package com.yedam.customer;

public class Customer {
//	CUSTOMER_ID    NOT NULL NUMBER
//	CUSTOMER_PW    NOT NULL NUMBER
//	CUSTOMER_NAME  NOT NULL VARCHAR2(20)
//	CUSTOMER_EMAIL          VARCHAR2(30)
//	CUSTOMER_ADD            VARCHAR2(100)
//	CUSTOMER_NUM   NOT NULL VARCHAR2(20)
//	CUSTOMER_GRADE          CHAR(1)
	
	private int customerId;
	private int customerPw;
	private String customerName;
	private String customerEmail;
	private String customerAdd;
	private String customerNum;
	private String customerGrade;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCustomerPw() {
		return customerPw;
	}
	public void setCustomerPw(int customerPw) {
		this.customerPw = customerPw;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerAdd() {
		return customerAdd;
	}
	public void setCustomerAdd(String customerAdd) {
		this.customerAdd = customerAdd;
	}
	public String getCustomerNum() {
		return customerNum;
	}
	public void setCustomerNum(String customerNum) {
		this.customerNum = customerNum;
	}
	public String getCustomerGrade() {
		return customerGrade;
	}
	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
	
}
