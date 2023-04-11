package com.yedam.menu;

public class Menu {
//	MENU_NAME  NOT NULL VARCHAR2(50)
//	MENU_PRICE NOT NULL NUMBER
//	MENU_SALES          NUMBER
	
	private String menuName;
	private int menuPrice;
	private int menuSales;
	
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public int getMenuSales() {
		return menuSales;
	}
	public void setMenuSales(int menuSales) {
		this.menuSales = menuSales;
	}
	
}
