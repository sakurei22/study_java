package Study;

// DTO
// Data Transfer Object

public class Student {
	private int number;
	private String name;
	
	public Student() {
		
	}

	public Student(int number, String name) {
		this.number = number;
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [number=" + number + ", name=" + name + "]";
	}
	
	/*
	 	
	 	this 참조
	 	자기 객체가 저장되어있는 heap영역의 주소


	public Student() {
		this.number = 123; // 멤버 변수 접근시 this
	}
	
	public Student getThis() {
		return this;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	*/
}
