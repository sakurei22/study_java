class Outer2{
	private int num = 0;
	
	class Member{
		void add(int n) { num += n; }
		int get() { return num; }
	}
}

public class MemberInner {
	public static void main(String[] args) {
		Outer2 o1 = new Outer2();
		Outer2 o2 = new Outer2();
		
		// o1을 기반 인스턴스 생성 (Outer2 인스턴스 없이 Member생성불가)
		Outer2.Member o1m1 = o1.new Member();
		Outer2.Member o1m2 = o1.new Member();
		
		// o2를 기반 인스턴스
		Outer2.Member o2m1 = o2.new Member();
		Outer2.Member o2m2 = o2.new Member();
		
		//o1 기반 생성된 두 인스턴스 메소드 호출
		o1m1.add(5);
		System.out.println(o1m2.get());
		o1m2.add(2);
		System.out.println(o1m2.get());
		
		//o2 기반 인스턴스 메소드 호출
		o2m1.add(10);
		System.out.println(o2m2.get());
		
	}
}
