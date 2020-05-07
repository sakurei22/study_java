package Studey_1_Singleton_pattern;

/*
	< Singleton pattern >
 	단 1개의 instance만을 이용해서 접근하는 패턴.
 */
public class mainClass {
	public static void main(String[] args) {

		YouClass ycls = new YouClass();
		MyClass mcls = new MyClass();
		HeClass hcls = new HeClass();

		ycls.method();
	}
}