class Outer{
	private static int num = 0;
	static class Nested1 {	//Static 네스티드 클래스
		void add(int n) { num +=n; }
	}
	static class Nested2 {	//Static 네스티드 클래스
		int get() { return num; }
	}
}

public class StaticNested {
	public static void main(String[] args) {
		Outer.Nested1 nst1 = new Outer.Nested1();  
		// Static 네스티드 클래스 인스턴스 생성문
		// 외부 클래스의 이름을 포함하는 형태로 인스턴스의 생성
		nst1.add(10);
		nst1.add(5);
		
		Outer.Nested2 nst2 = new Outer.Nested2();
		System.out.println(nst2.get());
	}
}
