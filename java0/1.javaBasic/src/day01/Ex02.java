package day01;

import java.util.Calendar;

//자바 연산자들
//산술 논리 비트 비교 증감
public class Ex02 {
	public static void main(String[] args) {
		//기본형 데이터타입
		// byte short int   long  float  double char(캐릭터) boolean
		// 8bit 16bit 32bit 64bit 작은실수  큰실수      문자              참/거짓
		// 기본형(실제 값을 저장) vs 참조형(메모리 주소값을 저장)
		// 해당 메모리 위치에 실제값이 들어가면 기본형
		// 해당 메모리 위치에 실제값이 아니라 heap영역 메모리 주소값이 들어가면 참조형
		
		//산술: + - * / %  연산자
		int number1 = 5;
		long number2 = 10;
		
		Ex02 e = new Ex02();
		Calendar calendar = Calendar.getInstance();
	
		System.out.println(number1);
		System.out.println(e);
		
		//논리: boolean 값에 대한 연산 -> &&, !, 
		//&&: 앤드 연산 -> 2개 값이 모두 true일때만 true
		//|| : or 연산 -> 2개 중 하나만  true여도 true
		// !: -> true는 false로, false는 true로
		boolean isTrue = true;
		boolean isFalse = false;
		System.out.println(isTrue && isFalse);
		System.out.println(isTrue || isFalse);
		System.out.println(!isTrue || isFalse);
		
		//비트: 2진법수에 대한 연산
		// & | ^ ~ << >>
		byte myByte = 3;  //00000011
		byte myByte2 = 4; //00000100
		// & 연산 : 2진법으로 변환 후 두 숫자의 같은 자리가 모두 1이면 1
		System.out.println(myByte & myByte2);
		// | 연산: 2진법으로 변환 후 두 숫자의 같은 자리 중 하나가 1이면 1
		System.out.println(myByte | myByte2);
		// ^ 연산: 2진법으로 변환 후 두 숫자의 같은 자리 값이 다르면 1
		System.out.println(myByte ^ myByte2);
		// ~ 연산: 0은 1로, 1은 0으로
		System.out.println(~myByte); //11111011  
		//컴퓨터에서 2진법 숫자의 제일 앞자리는 부호를 뜻한다. 0이면 +, 1이면 -
		//또한 숫자체계가 직선이 아닌 원형 세계이기 때문에 0111 1111 + 1 은 1000 0000 이 되면서 음수 최소값으로 바뀐다.
		//이러한 숫자쳬게 때문에 양수 최대값+1이 음수 최소값으로 바뀌는 것을 overflow
		//음수 최소값-1이 양수 최대값으로 바뀌는걸 underflow라고 한다.
		
		//강제로 overflow경험해보기
		System.out.println((byte)128);
		//강제로 underflow경험해보기
		System.out.println((byte)-129);
		
		//<<연산: 왼쪽 쉬프트연산. 자릿수를 이동시킨다.
		System.out.println(myByte << 2);  // 0000 0011  << 0000 001100 but. 바이트는 8자리
		// 앞에 두자리를 지워준다. -> 0000 1100
		//>> 연산: 오른쪽 쉬프트 연산. 자릿수를 오른쪽으로 이동시킨다.
		System.out.println(myByte2 >> 2);  // 0000 0100  >> 0000 0001
		myByte2 = -10; // 1111 0110
		System.out.println(myByte2 >> 2);  // 1111 0110
		System.out.println(myByte2 >>> 2); // 0011 1101 
		
		//비교: 크거나 작거나 같은 비교
		// > >= < <= == !=
		System.out.println(myByte > myByte2);
		
		//클래스의 비교
		String string1 = "abc";
		String string2 = new String("abc");
		String string3 = "abc";
		System.out.println(string1 == string2);
		System.out.println(string2 == string3);
		System.out.println(string1 == string3);
		System.out.println(string1.equals(string2));
		
		//증감: ++ --
		int myNumber = 5;
		System.out.println(myNumber++); // System.out.println(myNumber) 하고, myNumber++가 실행되서 5가 6이된다.
		System.out.println(myNumber);
		System.out.println(++myNumber); // ++myNumber가 실행되서 6이 7이되고, System.out.println(myNumber)가 실행되서 7이 출력된다.
		System.out.println(myNumber);
	}
}

