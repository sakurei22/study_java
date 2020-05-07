package Study_1_Class;
/*
 
 		1. 은닉성(캡슐화) 접근제어 private, public, protected
 			class내부에서  member변수, member메소드로 처리 / 외부에서는 메소드로 접근
 			변수에 접근하는 경우 getter, setter통해서 접근
 
 */


public class MyClass {
	
	private int number;
	private String strArr[];
	
	public MyClass() { // 생성시 자동호출 메소드. overload가능
	//	this(1);
		System.out.println("MyClass MyClass()");
		strArr = new String[10];
	}
	
	public MyClass(int number) {
		this();					// 생성자 호출할떄도 this 사용.
		this.number = number;
		System.out.println("MyClass MyClass(int number)");
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	public void method() {
		System.out.println("method()");
		System.out.println("number = "+ this.number);
	}
	
}
