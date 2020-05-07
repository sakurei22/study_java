package Work_2_BaseBallMember;

public class Human {
	protected int number;
	protected String name;
	protected int age;
	protected double height;
	
	public Human(){
		
	}

	@Override
	public String toString() {
		return "Human [number=" + number + ", name=" + name + ", age=" + age + ", height=" + height + "]";
	}

	public Human(int number, String name, int age, double height) {
		super();
		this.number = number;
		this.name = name;
		this.age = age;
		this.height = height;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	
}
