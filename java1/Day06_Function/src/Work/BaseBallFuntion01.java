package Work;

import java.util.Scanner;

public class BaseBallFuntion01 {
	public static void main(String[] args) {
		/*
		 * 두군데 이상 변수가 필요하면 메인에 변수선언 필요.
		 * 
		 * 1. 초기화
		 * 
		 * 2. random 산출
		 * 
		 * ////////////////// loop 시작 3. user input - Scanner
		 * 
		 * 4. 판정
		 * 
		 * 5. 메세지 출력 /////////////////// loop 끝
		 * 
		 * 6. 결과처리
		 * 
		 */

		int r_num[], u_num[]; // 같은용도의 변수면 배열로 잡는게 편함.
		boolean clear; // 판정. 결과처리
						// 두개 이상의 장소에서 쓰이면 main에서 선언하여
						// 초기화 하는것이 좋다.
		// 1.초기화
		r_num = new int[3];
		u_num = new int[3];
		clear = false;

		// 2.random 산출
		ballRandom(r_num);

		int w = 0;
		w = 0;
		int message[] = new int[2];
		while (w < 10) {

			// 3. user input
			u_num = userInput(u_num);
			// 4. finding
			clear = finding(r_num, u_num, message);
			if (clear)
				break;
			// 5. 메시지
			System.out.println(message[0] + "스트라이크 " + message[1] + "볼입니다.");
			w++;
		}
		
		// 6. 결과처리
		if (clear) {
			System.out.println("Game Clear!!");
		} else {
			System.out.println("Game Over~");
		}

	}

	static void ballRandom(int r_num[]) {
		boolean _switch[] = new boolean[10];
		int w, r;
		w = 0;
		while (w < 3) {
			r = (int) (Math.random() * 10); // 0~9
			if (_switch[r] == false) {
				_switch[r] = true; // ff t ff fffff
				r_num[w] = r + 1; // 1~10
				w++;
			}
		}

		for (int i = 0; i < r_num.length; i++) {
			System.out.println("r_num[" + i + "]= " + r_num[i]);
		}
	}

	static int[] userInput(int unum[]) {
		Scanner sc = new Scanner(System.in);
		while (true) {

			for (int i = 0; i < unum.length; i++) {
				System.out.print((i + 1) + "번째 수 = ");
				unum[i] = sc.nextInt();

			}
			if (unum[0] != unum[1] && unum[0] != unum[2] && unum[1] != unum[2]) {
				break;
			}
			System.out.println("중복된 숫자가 있습니다.");
		}
		return unum;
	}

	static boolean finding(int rnum[], int unum[], int message[]) {
		int strike = 0, ball = 0;
		// ball
		for (int i = 0; i < rnum.length; i++) {
			for (int j = 0; j < rnum.length; j++) {
				if (rnum[i] == unum[j] && i != j) {
					ball++;
				}
			}
		}
		// strike
		for (int i = 0; i < rnum.length; i++) {
			for (int j = 0; j < rnum.length; j++) {
				if (rnum[i] == unum[j]) {
					strike++;
				}
			}
		}
		message[0] = strike;
		message[1] = ball;

		// 판정
		if (strike > 2) {
			return true;
		}
		return false;
	}
}
