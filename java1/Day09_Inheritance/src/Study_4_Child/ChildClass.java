package Study_4_Child;

import Study_4_Parents.ParentsClass;

public class ChildClass extends ParentsClass{
	private String name;
	
	public ChildClass() {
		super();
		System.out.println("ChildClass ChildClass()");
	}
	public ChildClass(String name, int num) {
		super(num);
		this.name = name;
		System.out.println("ChildClass ChildClass(String name)");
	}
}
