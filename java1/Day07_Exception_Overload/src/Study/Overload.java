package Study;

public class Overload {
	public static void main(String[] args) {
		/*
		 
		 Over Load :	함수(메소드)명은 같고  
		 (동명이인)		인자, 인수(매개변수)의 자료형이나
		 				인수의 갯수가 다른 다른 함수를 의미한다.
		 
		 ex) image draw function
		 	RGB, RGBA(투명도)
		 	imageDraw(int x, int y);
		 	imageDraw(int x, int y, int a);
		 
		 
		 Over Ride -> 상속성, 다형성
		 
		 */
		
		func();
		func('A');
		func(123);
		func('B', 123);
		func(345, 'C');
	}
	
	static void func() {
		System.out.println("1.func()");
	}
	
	static void func(char c) {
		System.out.println("2.func(char c) 호출");
	}
	
	static void func(int i) {
		System.out.println("3.func(int i) 호출");
	}
	
	static void func(char c, int i) {
		System.out.println("4.func(char c, int i) 호출");
	}
	
	static void func(int i, char c ) {
		System.out.println("5.func(int i, char c) 호출");
	}
	/*													리턴값 x
	static int func(int i, char c ) {
		System.out.println("5.func(int i, char c) 호출");
		return 1;
	}
	*/
	/*													가인수 x
	static void func(int j, char ch ) {
		System.out.println("5.func(int i, char c) 호출");
	}
	*/
}
