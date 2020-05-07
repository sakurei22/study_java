package Studey_1_Singleton_pattern;

import java.util.Scanner;

public class MyClass {
	private int myNum;

	public MyClass() {
		Scanner sc = new Scanner(System.in);
		System.out.print("번호를 입력하세요: ");
		myNum = sc.nextInt(); // 건네줄 변수

		Singleton single = Singleton.getInstance();
		single.num = myNum; // singleton으로 건네줌
	}

	/*
	 * public int getMyNum() { return myNum; }
	 */
}