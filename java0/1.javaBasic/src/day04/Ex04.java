package day04; // 로그인시스템

import java.util.Scanner;

// 로그인시스템만들기
//사용자로부터 id와 pw받아
//화원가입 ->로그인
//id 4글자 이상 13글자 미만
//pw 6글자이상
//로그인시에 id와 비밀번호 둘중 하나만 틀려도
//정확히 뭐가 틀렷는지는 말하지 않고
// id 혹은 pw가 틀렷습니다.
// 라고 풀력이되고
// 둘다 맞을 시에는 '로그인 성공!' 이란 메세지가 출력되게 만드세요.
public class Ex04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);				//입력받아야되니 받아야할 스캐너 객채만들기
		
				System.out.println("가입할 ID를 입력해주세요");
				System.out.print(">");
				String id = scanner.nextLine();
				System.out.println("가입할 PW를 입력해주세요");
				String pw = scanner.nextLine();
				
				if(id.length() >= 4 && id.length() < 13 && pw.length() >=6) {
					System.out.println("===비트 로그인 시스템===");
					System.out.println("id: ");
					String userName = scanner.nextLine();
					System.out.println("pw: ");
					String userPw = scanner.nextLine();
					if(id.equalsIgnoreCase(userName) && pw.equals(userPw)) {
						System.out.println("로그인 성공!!");
					}else {
						System.out.println("로그인 실패!!");
					}
					
			
			}
		}
	}
