package day03;

import java.util.Scanner;

//스캐너 버그 - 스캐너는 숫자만 가져간다.
//숫자입력 다음에 문자열입력 받을땐
//scanner.nextLine(); 한번더 실행시켜 남아있는 '엔터'입력을 날린뒤 나머지 실행
public class Ex01 {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
			System.out.println("회원번호: ");
			int userId = scanner.nextInt();
			scanner.nextLine();
			System.out.println("회원이름: ");
			String name = scanner.nextLine();
			System.out.println("번호: " + userId);
			System.out.println("회원 이름: "+ name);
			scanner.close();
			
					
	}
}
