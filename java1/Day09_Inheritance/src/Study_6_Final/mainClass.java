package Study_6_Final;

public class mainClass {
	public static void main(String[] args) {
		MyClass cls = new MyClass();
		
		cls.method();
		cls.method();
		
		MyClass cls1 = new MyClass();
		
		cls1.method();
		cls1.method();
		
		//상수 (주로 대입용)
		final int NUMBER = 3;	//define(c), const(c++)
		int num;
		
		num = NUMBER; // 상수를 대입했다는 가독성
		Object mcls = new YouClass();	// Object클래스는 전부 담을수있다.
		
		MyClass my = (MyClass)mcls;
		YouClass yo = (YouClass)my;
		
		YouClass ycl = new YouClass();
		//MyClass my = (MyClass)ycl;	// 불가능
		
		
	}
}
//클래스 앞에 final : 상속 금지
 class MyClass{
	private int number;	//member 변수
	public static int stNumber;	// static 변수
	
	
	//메소드dp final : over ride 금지
	public void method() {
		int num = 0;		//local 변수
		num++;
		this.number++;
		MyClass.stNumber++;
		
		System.out.println("num= " + num);
		System.out.println("number= " + number);
		System.out.println("stNumber= " + stNumber);
	}
}

class YouClass extends MyClass{
	
	/*
	 * public void method() { }
	 */
}
