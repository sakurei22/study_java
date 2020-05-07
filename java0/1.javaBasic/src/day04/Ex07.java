package day04; // 가위바위보게임

import java.util.Random;
import java.util.Scanner;

//가위바위보 게임
public class Ex07 {
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		String[] rsp = { "가위", "바위", "보" };
		System.out.println("1.가위 2.바위 3.보");
		System.out.print(">");

		int userChoice = scan.nextInt() - 1;
		if (userChoice < 0 || userChoice > 2) {
			System.out.println("잘못 입력하셨습니다.");
		} else {
			int computerChoice = rand.nextInt(3);
			System.out.println("사용자: " + rsp[userChoice]);
			System.out.println("컴퓨터: " + rsp[computerChoice]);
			if (userChoice == computerChoice) {
				System.out.println("무승부");
			} else {
				switch (userChoice) {
				case 0:
					if (userChoice == 1) {
						System.out.println("패배");
					} else {
						System.out.println("승리");
					}
					break;
				case 1:
					if (userChoice == 2) {
						System.out.println("패배");
					} else {
						System.out.println("승리");
					}
					break;
				case 2:
					if (userChoice == 0) {
						System.out.println("패배");

					} else {
						System.out.println("승리");
					}
					break;
				}
			}
		}

	}
}
