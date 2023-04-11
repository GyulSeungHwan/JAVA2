package com.yedam.time;

public class Time {
//	TIME_NAME  NOT NULL NUMBER
//	TIME_PRICE NOT NULL NUMBER
//	TIME_SALES          NUMBER
	
	private int timeName;
	private int timePrice;
	private int timeSales;
	
	public int getTimeName() {
		return timeName;
	}
	public void setTimeName(int timeName) {
		this.timeName = timeName;
	}
	public int getTimePrice() {
		return timePrice;
	}
	public void setTimePrice(int timePrice) {
		this.timePrice = timePrice;
	}
	public int getTimeSales() {
		return timeSales;
	}
	public void setTimeSales(int timeSales) {
		this.timeSales = timeSales;
	}
	
}