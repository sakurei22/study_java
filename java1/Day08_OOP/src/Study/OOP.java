package Study;

public class OOP {
	public static void main(String[] args) {
		/*
		Object Oriented Programming
												cf) API Application Programming Interface
													AOP Aspect Oriented Programming
		처리 중심.
		설계 중요.
		
		!= 절차 지향 : 순차적 처리(속도)
				
		1. 은닉성(캡슐화)
		2. 상속성
		3. 다형성
		
			<class 설계>
		class + 클래스명
		{
			--변수부
			접근지정자 + 변수자료형 + 변수명;	member변수
			
			--메소드부
			접근지정자 + 자료형 + 메소드명(매개변수){
			
			}
		}
		
		변수(객채)를 선언후에 동적할당을 해야 접근가능.
		
		class 변수 -> object(객체), instance(주체)
									ㄴ실제 메모리 영역에  올라가는 변수
									
		클래스명 + 인스턴스 = new 클래스명();
		
		인스턴스	->	실제영역
		stack		heap
	*/
		
		MyClass1 cls;		// cls == instance 
		cls = new MyClass1();	//동적할당.  heap.		cls:stack
		
		cls.c = 'A';
		cls.x = 12;
		cls.func();
		cls.method(33);
		
		//tv(안방, 홀 , 내방) 
		String name[] = new String[3];
		int channel[] = new int[3];
		boolean power[] = new boolean[3];
		
		
		TVclass tv1, tv2, tv3;
		tv1 = new TVclass();
		tv2 = new TVclass();
		tv3 = new TVclass();
		
		TVclass arrTV[] = new TVclass[3];
		for (int i = 0; i < arrTV.length; i++) {
			arrTV[i] = new TVclass();
		}
		arrTV[0].setChannel(11);
		
		
		tv1.setName("LG");
		tv2.setName("Samsung");
		tv3.setName("Dawoo");
		
		tv1.setPower(true);
		tv2.setPower(false);
		tv3.setPower(true);
		
		String tvName = tv1.getName();
		
	}
}

class MyClass1{
	// 변수부(member)
	int x, y;
	char c;
	String str;
	
	// 메소드부
	void func() {
		x = 0;
		System.out.println("My Class func()");
	}
	void method(int i) {
		str = "hello";
		x = i;
		System.out.println("MyClass method(int i)");
		System.out.println("x = "+ x);
		
	}
	
}

class TVclass{
	String name;
	int channel;
	boolean power;
	
	
	void setName(String newName) {
		name = newName;
	}
	String getName() {
		return name;
	}
	void setChannel(int newChannel) {
		channel = newChannel;
	}
	int getChannel() {
		return channel;
	}
	void setPower(boolean pow) {
		power = pow;
	}boolean getPower(){
		return power;
	}
}
















