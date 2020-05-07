package Study_1_Abstract;

public abstract class AbstractClass { //상속 받은 쪽에서 알아서 해. interface와 비슷 
	private int number;
	
	public void method() {	//일반 메소드
		System.out.println("AbstractClass method()");
	}
	
	// 추상 메소드
	public abstract void abstractMethod();
}
