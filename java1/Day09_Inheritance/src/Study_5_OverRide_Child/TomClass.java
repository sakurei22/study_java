package Study_5_OverRide_Child;

import Study_5_OverRide_Parents.ParentClass;

public class TomClass extends ParentClass {
	
	public void ParentMethod() {		// OverRide Method
		System.out.println("TomClass parenMethod()");
	}
	
	public void func() {
		System.out.println("TomClass func()");
	}
}
