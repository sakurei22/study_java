package day04; //wrapper class

import java.util.Scanner;

//wrapper class
//기본형 데이터타입을 클래스처럼 만들어 놓은것
//wrapper class(포장 클래스) 라고 한다.

public class Ex05 {
	public static void main(String[] args) {
		Integer i = 0;
		Scanner scanner = new Scanner(System.in);
		//메소드를 통한 형변환
		//각 wrapper 클래스들은 parse메소드들이 있다.
		//String으 해당클래스로 바꿔준다
		try {
			System.out.println("숫자를 입력해주세요");
			String userNumber = scanner.nextLine();
			Integer convertedNumber = Integer.parseInt(userNumber);
			System.out.println(convertedNumber);
		}catch(NumberFormatException e) {   //(Exception e) : 포괄적인 에러해결
			System.out.println("잘못된형식입니다.");
		}
		
		System.out.println(i);
	}
}
