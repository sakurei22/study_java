package Study;

public class MyClass {

	private float number; // 멤버 변수
	
	
	public MyClass() {
	
		System.out.println("MyClass MyClass()");
	}
	
	public MyClass(int n) {
		System.out.println("MyClass MyClass(int n)");
	}
	
	public MyClass(float _number) {
		number = _number;
	}
	
	
	public float getNumber() {
		return number;
	}
	
	public void setNumber(float _number) {
		number = _number;
	}
	
}
