package Studey_1_Singleton_pattern;

import java.util.Scanner;

public class HeClass {
	private String name;
	
	public HeClass() {
		System.out.print("이름을 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		name = sc.next();	// 건네줄 변수
		
		Singleton s = Singleton.getInstance();
		s.name = name;	// singleton으로 건네줌
	}
}