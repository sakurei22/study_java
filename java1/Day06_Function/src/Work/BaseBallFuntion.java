package Work;

import java.util.Scanner;

public class BaseBallFuntion {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int r_num[], u_num[]; // 같은용도의 변수면 배열로 잡는게 편함.
			boolean clear;
			int strike, ball;
	
	//		 -------------------------------------------------loop
	//		 1.초기화
			r_num = new int[3];
			u_num = new int[3];
			clear = false;
			boolean _switch[] = new boolean[10];
			int w, r;
			int count = 0;
	//		 2.random
	//		while (true) {
	//			
	//			for (int i = 0; i < r_num.length; i++) {
	//				r_num[i] = (int) (Math.random() * 10) + 1;
	//
	//			}
	//			if(	r_num[0] != r_num[1] &&
	//					r_num[0] != r_num[2] &&
	//						r_num[1] != r_num[2]) {
	//				break;
	//			}
	//		}
	
			for (int i = 0; i < _switch.length; i++) { // fffff fffff : 스위치 다 꺼놓음
				_switch[i] = false;
			}
	
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
	
			//////////////////////////// loop
			w = 0;
			while (w < 10) {
	
				strike = 0;
				ball = 0;
	//		 3.user input    -> 주제가 되는 변수들 뽑아내서 목록작성
				while (true) {
	
					for (int i = 0; i < u_num.length; i++) {
						System.out.print((i + 1) + "번째 수 = ");
						u_num[i] = sc.nextInt();
	
					}
					if (u_num[0] != u_num[1] && u_num[0] != u_num[2] && u_num[1] != u_num[2]) {
						break;
					}
				}
	
	//		 4 finding 
	
				// ball
				for (int i = 0; i < r_num.length; i++) {
					for (int j = 0; j < r_num.length; j++) {
						if (r_num[i] == u_num[j] && i != j) {
							ball++;
						}
					}
				}
	
				// strike
				for (int i = 0; i < r_num.length; i++) {
					for (int j = 0; j < r_num.length; j++) {
						if (r_num[i] == u_num[j]) {
							strike++;
						}
					}
				}
				// 판정
				if(strike >2) {
					count = w+1;
					clear = true;
					break;
				}
				//메시지
				System.out.println(strike+"스트라이크 "+ball+"볼입니다.");
	
				w++;
			}
	
			////////////////////////////
	//		 5. result
			if(clear) {
				System.out.println(count+"회 Game Clear!!");
			}else {
				System.out.println("Game Over~");
			}
	//		 ---------------------------------------------------
	
			sc.close();
		}
	}
	


