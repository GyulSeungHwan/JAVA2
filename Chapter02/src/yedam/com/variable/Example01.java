package yedam.com.variable;

public class Example01 {
	public static void main(String[] args) {
		//int
		int var1 = 0b1011; //2진수(0b)
		int var2 = 0206; //8진수(0)
		int var3 = 365; //10진수
		int var4 = 0xB3; //16진수(0x)
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
		System.out.println(var4);
		
		//byte 127
		byte bVal = -128;
		byte bVal2 = 0;
		byte bVal3 = 127;
		int bVal4 = 500;
		//byte는 -128에서 127까지밖에 못 읽는다
		
		System.out.println(bVal4);
		
		//long
		//정수 -> 기준 int
		
		long lVal = 10;
		long lVal2 = 20;
		//기준 int의 데이터 범위를 벗어나서, L을 붙인다.
		long lVal3 = 10000000000L;
		
		//char(유니코드)
		//문자 => 하나의 문자만 들어가는 경우
		//ex) 'A', 'B'
		//문자열 => 하나 이상의 문자가 모이는 경우
		//ex) "apple"
		
		char charVal1 = 'A';
		char charVal2 = '가';
		char charVal3 = 67;
		char charVal4 = 0x0041;
		//문자로 표현해서 출력이 된다
		
		System.out.println(charVal1);
		System.out.println(charVal2);
		System.out.println(charVal3);
		System.out.println(charVal4);
		
		//문자열
		//String
		char charVal5 = '홍';
		String str1 = "홍길동";
		String str2 = "프 로 그 래 머safsdfsags";
		
		System.out.println(str1);
		System.out.println(str2);
		
		//이스케이프
		//탭만큼 띄움 (\t)
		System.out.println("번호\t이름\t직업");
		//엔터키 (\n)
		System.out.println("행 단위 출력\n");
		//특수문자 사용 (\", \', \\)
		System.out.println("우리는 \"개발자\" 입니다.");
		//특수문자 사용2
		System.out.println("봄\\여름\\가을\\겨울");
		
		//실수 타입
		//float
		float fVal = 3.14f;
		//double
		double dVal = 3.14;
		
		//e 사용하기
		double dVal2 = 3e6; // 3.0 * 10의 6승
		float fVal2 = 3e6f; // 3.0 * 10의 6승
		double dVal3 = 2e-3; // 2.0 * 10의 -3승 ==> 2/1000
		
		System.out.println(dVal2);
		System.out.println(fVal2);
		System.out.println(dVal3);
		
		//논리타입 - true false
		boolean stop = true;
		
		if(stop == true) {
			System.out.println("중지합니다.");			
		}else {
			System.out.println("시작합니다.");
		}
	}

}
