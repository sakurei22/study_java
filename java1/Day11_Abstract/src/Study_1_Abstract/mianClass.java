package Study_1_Abstract;

public class mianClass {
	public static void main(String[] args) {
		/*
		 	abstract :	추상 class
		 				추상 method를 한개 이상 포함하고 있는 것.
		 				-> 내용물 작성x. 필요한 것을 알아서 작성.(개발자용)
		 	
		 	class : method의 내용이 모두 설정되어 있는 것
 			추상 method : method가 정의만 되어 있는 요소
		 	
		 	추상 class만은 생성이 불가능하다.
		 	추상 class를 상속한 후에 자식 class에서 정의 후에 생성이 가능하다.
		 	instance로 설정은 가능.
		 	
		 */
		
		
		//AbstractClass ac = new AbstractClass();
		
		Child_myClass cls = new Child_myClass();
		cls.abstractMethod();
		cls.method();
		
		AbstractClass myCls = new Child_myClass();
		myCls.abstractMethod();
		myCls.method();
		
		AbstractClass aCls = new AbstractClass() {
			@Override
			public void abstractMethod() {
				System.out.println("abstractMethod() 상속안하고 정의");
			}
		};
		aCls.abstractMethod();
		aCls.method();
		
		AbstractClass mCls = new Child_myClass();
		
		AbstractClass nCls = new Child2_youClass();
		
	}
	
}
