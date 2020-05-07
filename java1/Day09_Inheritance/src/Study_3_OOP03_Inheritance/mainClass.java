package Study_3_OOP03_Inheritance;

import Study_3_Inheritance01.ChildClass;
import Study_3_Inheritance01.SuperClass;

public class mainClass {
	public static void main(String[] args) {
		ChildClass cc = new ChildClass();
		
		cc.Super_method();
		cc.Child_func();
		cc.pub_name = "aaa";		//main 에서도 접근 가능하지만 은닉성 결여.
	//	cc.pro_name = "bbb";
		
		
		
		SuperClass sc = new SuperClass();
		sc.Super_method();
	//	sc.Child_func();
		
	}
}
