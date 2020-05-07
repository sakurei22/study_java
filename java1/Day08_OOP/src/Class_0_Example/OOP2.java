package Class_0_Example;

public class OOP2 {
	public static void main(String[] args) {
		/*
		 
		 	1. 은닉성 (==캡슐화)
		 		: 외부와의 차단으로 변수들을 관리할 수 있다.
		 		     클래스 내부에서만 접근(처리)이 가능하도록 접근지정자로 제어한다.
		 		  
		 		  private(개인적인)			-> 멤버변수
		 		  public(대중적인)				-> 멤버 메소드
		 		  protected(특정) - 상속 관련	-> 
		 		  
		 
		 */
		MyClass cls = new MyClass();
//		cls.number = 1;
//		cls.name ="hgd";
//		cls.height = 172.1;
		
		cls.input();
		cls.printing();
		
		String name = cls.getName();
		System.out.println("name="+ name);
	}
}
