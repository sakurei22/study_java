package day04;

public class Ex01 {
	public static void main(String[] args) {
		// 상속받는 클래스는 부모클래스의 필드를 사용할 수 있다.
		// private인 경우 getter/setter 사용
		Student s = new Student();
		// 먼저 부모클래스의 생성자를 호출해서 heap메모리에
		// 부모클래스가 가지고 있는 필드와 메소드를 넣고
		// 그리고 자식 클래스의 필드와 메소드를 넣는다.
		s.setJumin("991111-1111111");
		s.setName("신종하");
		s.eat();
		s.speak();
		
		System.out.println(s);
		Korean k = new Korean();
		Japanese J = new Japanese();
		Human me = new Japanese();
		torture(k);
		
	}
	public static void torture(Korean k) {
		k.play();
	}
}
