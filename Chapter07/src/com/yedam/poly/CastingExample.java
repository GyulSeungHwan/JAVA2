package com.yedam.poly;

public class CastingExample {
	public static void main(String[] args) {
		//강제 타입 변환(Casting)
		//부모 타입으로 만들어진 다형성(부모가 가진 내용만 사용하되
		//자식 클래스에서 오버라이딩 된 내용은 자식 클래스 것을 사용)
		//자식이 가진 내용도 쓰고싶다 -> 강제 타입 변환
		
		//자동 타입 변환
		Parent parent = new Child();
		
		parent.field = "부모필드";
		parent.method1();
		parent.method2();
//		parent.method3();
//		parent.field2 = "자식필드"; //되지않는다
		//강제 타입 변환(Casting)
		//조건 : 클래스간의 자동 타입 변환이 발생 후 사용 가능
		Child child = (Child)parent;
		child.field = "부모필드";
		child.method1();
		child.method2(); //기존에 부모가 가지고있던 필드를 사용하고
		
		child.field2 = "자식필드";
		child.method3(); //추가로 사용이 가능해졌다
		
		//instanceof
		//같은 인스턴스인지 사용
		//== : 주소 비교
		//instanceof : 같은 타입의 객체인지 확인
		Parent p1 = new Parent();
		Parent p2 = new Parent();
		
		if(p1 == p2) {
			System.out.println("주소가 같음");
		}else {
			System.out.println("주소가 다름");
		}
		
		if(p1 instanceof Parent) {
			System.out.println("p1은 Parent 타입입니다.");
		}else {
			System.out.println("p1은 Parent 타입이 아닙니다.");
		}
		
		if(parent instanceof Parent) {
			System.out.println("부모 타입");
		}
		if(parent instanceof Child) {
			System.out.println("자식 타입");
		}
	}
}
