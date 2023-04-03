package com.yedam.inheri;

public class Application01 {
	public static void main(String[] args) {
		Child child = new Child();
		
		child.lastName = "이";
		child.getInfo();
		child.money = 1000;
		//Parent의 getInfo에서 money는 private를
		//줬기때문에 money는 상속받지 못한다 
	}
}
