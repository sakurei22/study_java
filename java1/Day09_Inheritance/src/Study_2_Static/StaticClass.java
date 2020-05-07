package Study_2_Static;

public class StaticClass {
	private int number;				// instance 변수
	
	public static int staticNumber;	// class 변수
									// 전체흐름 파악할때
	/*
	 		stack	heap	static	sys
	 		local	new		정적 - 메모리에 상주(남발x, 항상 값을 유지)	
	 				동적할당
	 */
	
	public StaticClass() {
	}
	
	public void method() {
		staticNumber++;
	}
}
