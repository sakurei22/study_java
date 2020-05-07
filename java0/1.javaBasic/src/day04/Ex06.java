package day04; // 랜덤숫자맞추기

import java.util.Random;
import java.util.Scanner;

//random을 이용한 숫자 맞추기 게임
public class Ex06 {
	public static void main(String[] args) {
		Random rand = new Random();
		// 랜덤 클래스는 0~1 사이의 무수한 실수 단수들을 갖고 있다.
		// 즉, 0~1사이의 순서가 일정하지 않은 랜덤한 숫자를 갖고 있는 형태이고
		// 사용자가 요청하면 그 숫자를 하나 꺼내준다.
		
		int randomNumber = rand.nextInt(50)+1; // 0~49 사이의 랜덤 숫자 한개
		Scanner scanner = new Scanner(System.in);
		int userNum = -1;
		int score = 1;
		do {
			System.out.println("숫자를 입력해주세요.");
			userNum = scanner.nextInt();
			if(userNum > randomNumber) {
				System.out.println("DOWN");
				score++;
			}else if(userNum < randomNumber) {
				System.out.println("UP");
				score++;
			}
		}while(userNum != randomNumber);
		System.out.println("정답!!!");
		System.out.println(score+"번 만에 맞추셨습니다.");
	}
}
