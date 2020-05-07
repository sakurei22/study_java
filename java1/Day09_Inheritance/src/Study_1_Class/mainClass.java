package Study_1_Class;

public class mainClass {
	
	public static void main(String[] args) {
		
	//	MyClass cls = new MyClass();	// instance
		
		MyClass cls = new MyClass(12);
		
		mainClass mcls = new mainClass();
		mcls.func();
	}
	
	public void func() {
		System.out.println("mainClass func()");
	}
}
