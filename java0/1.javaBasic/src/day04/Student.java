package day04; // 상속

//상속에는 2가지 개념이있다.
// 1: 클래스상속
//		재사용성을 위한 상속
// 2: 인터페이스 상속
//		polymorphism을 위한 상속  - poly: 다양한, porph: 모양
//		다양한 모양의 성격 = 다형성

//클래스 상속은 extends 라는 명령어를 통해서 이뤄진다.
public class Student extends Korean {
	public Student() {
		System.out.println("student() 실행");
	}
	//overriding
	//부모클래스로부터 상속받은 클래스를
	//자식이 재정의해서 쓰는것.
	//자식 클래스가 오버라이딩하면 해당 메소드는 자식 클래스의 매소드가 실행된다.
	public String toString() {
		return "Student 클래스의 toString()메소드";
	}
	//단 오버라이딩하실때에는
	//부모클래스의 메소드 선언부와 완전히 동일해야한다.
	//다르면 오버라이딩이 아니라 '오버로딩'이 된다.
	
	public void eat() {
	 System.out.println("급식을 먹는다.");	
	}
}
