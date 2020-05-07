package Study_2_0_Interface;

import Study_2_2_Writer.Ballpen;
import Study_2_2_Writer.Pencil;
import Study_2_2_Writer.WriteMode;

public class mainClass {
	public static void main(String[] args) {
		/*
		 	
		 	abstract class:	method + abstract method
		 				 	변수의 선언이 가능.
		 					class 다중상속이 불가능.
		 					 
		 	interface : abstract method만으로 이루어져 있다.(선언)
		 				변수 선언이 불가능.
		 				다중상속 가능*
		 				-> 공통작업에 편리(개발자용)
		 */
		
		Child_myClass cls = new Child_myClass();
		cls.method();
		cls.func();
		
		Interface inter = new Child_myClass();
		inter.method();
		inter.func();
		
		Interface In = new Interface() {
			
			@Override
			public void method() {
				
			}
			
			@Override
			public void func() {
				
			}
		};
		
		WriteMode wm = new Pencil();	// = new Ballpen();
		wm.writer();
		if(wm instanceof Pencil) {
			((Pencil)wm).erase();
			
		}else {
			((Ballpen) wm).erase();
		}
	}
}
