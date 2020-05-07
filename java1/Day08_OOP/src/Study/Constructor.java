package Study;

public class Constructor {
	public static void main(String[] args) {
		/*
		 	constructor : 생성자					cf) Structure : C언어 
		 				함수(메소드)					 	struct AAA{
		 				class명과 같은 method						int i;
		 				return 값이 없다.							char c;
		 				Over loading이 가능하다.			}
		 				자동호출(class생성시)								
		 				별도의 호출이 불가능하다.(1회용)			AAA aaa = { 1, 'A' };
		 				생략 가능.
		 				초기 값 설정에 많이 사용
		 	
		 	// destructor : 소멸자(C++)
		 	 				자동 호출
		 	
		 	this : 참조
		 	
		 */
		
		MyClass cls = new MyClass();	//기본생성자
		
		MyClass cls1 = new MyClass(2);
		
		MyClass cls2 = new MyClass(12.3f);
		
		float f = cls2.getNumber();
				System.out.println("f= " + f);
		
		Student stu = new Student();
		System.out.println(stu);
		
				
	}
}
