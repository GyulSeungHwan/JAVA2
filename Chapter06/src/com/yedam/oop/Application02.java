package com.yedam.oop;

public class Application02 {
	public static void main(String[] args) {
		Car sonata = new Car("소나타", 10000);
		//Car.java에서 매개변수를 넣어서 오류가 낫기 때문에
		//여기에도 매개변수의 수를 맞춰주었다
		
		System.out.println(sonata.company);
		System.out.println(sonata.name);
		System.out.println(sonata.price);
		
//		sonata.name = "소나타";
//		sonata.price = 10000;
//		System.out.println();
//		System.out.println(sonata.company);
//		System.out.println(sonata.name);
//		System.out.println(sonata.price);
//		
//		sonata.company = "기아자동차";
//		
//		System.out.println();
//		System.out.println(sonata.company);
//		System.out.println(sonata.name);
//		System.out.println(sonata.price);
//		
//		Car kona = new Car();
//		System.out.println("===코나===");
//		System.out.println(kona.company);
//		System.out.println(kona.name);
//		System.out.println(kona.price);
//		
//		kona.name = "코나";
//		kona.price = 100;
//		
//		System.out.println();
//		System.out.println(kona.company);
//		System.out.println(kona.name);
//		System.out.println(kona.price);
	}
}
