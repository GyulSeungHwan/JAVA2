package com.yedam.seller;

public class Seller {
//	CUSTOMER_ID     NUMBER
//	TIME_NAME       VARCHAR2(20)
	
	private int customerId;
	private int timeName;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getTimeName() {
		return timeName;
	}
	public void setTimeName(int timeName) {
		this.timeName = timeName;
	}
	
}
