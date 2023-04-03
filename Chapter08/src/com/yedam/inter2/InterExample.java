package com.yedam.inter2;

public class InterExample {
	public static void main(String[] args) {
		InterFaceC ic = new ImpelemetnsC();
		ic.methodA();
		ic.methodB();
		ic.methodC();
		
		InterFaceB bc = new ImpelemetnsC();
		bc.methodB();
		
		InterFaceA ac = new ImpelemetnsC();
		ac.methodA();
	}
}
