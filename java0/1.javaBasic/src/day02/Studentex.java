package day02;
// 필드의 값이 같으면 같은 객체
public class Studentex {
	public static void main(String[] args) {
		Student s = new Student("신종하", 17, 90, 80, 70, "991111-1111111");
		
		System.out.println(s.getName());
		System.out.println(s.getAge());
		Student s2 = new Student();
	
		
	}
}
