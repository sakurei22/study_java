package Work;

import java.util.Scanner;

public class SortFunction {
	public static void main(String[] args) {
		// number[], updown
		int number[];
		boolean updown[] = new boolean[1]; //

		// 1.입력
		// input output
		number = userInput(updown);

		// 2.정렬처리
		sorting(number, updown[0]);

		// 3.결과처리
		printing(number);
	}

	static int[] userInput(boolean ud[]) {
		Scanner sc = new Scanner(System.in);
		int count;
		// 1.input
		System.out.print("몇개 숫자를 정렬?");
		count = sc.nextInt();

		// allocation(할당)
		String strNum[] = new String[count];

		// 정렬할 숫자들을 입력;
		boolean ok = true; // 중간에 문자가있다면 false

		int w = 0;
		while (w < strNum.length) {
			ok = true;
			System.out.println((w + 1) + "번째 수 = ");
			strNum[w] = sc.next(); // 조사할땐 문자로 입력받는것이 편함.

			// 정상적으로 숫자를 입력했는지 확인
			for (int i = 0; i < strNum[w].length(); i++) { // String의 함수 length()
				int n = strNum[w].charAt(i);
				if (n < 48 || n > 57) {
					ok = false;
					break;
				}
			}
			if (ok == false) { // 문자가 있을떄
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요");
				continue;
			}
			w++;
		}

		// 올림? 내림?
		System.out.println("1.올림  2.내림");
		int updown = sc.nextInt();
		if (updown == 1)
			ud[0] = true;
		else
			ud[0] = false;

		for (int j = 0; j < strNum.length; j++) {
			System.out.println("strNum[" + j + "]=" + strNum[j]);
		}

		// 2. 대입(변환)
		// 숫자로 변환해 줄 배열
		int number[] = new int[strNum.length];

		for (int i = 0; i < strNum.length; i++) {
			number[i] = Integer.parseInt(strNum[i]);

		}
		return number;
	}

	static void sorting(int num[], boolean ud) {
	// 3. sorting
		int temp;
		for (int i = 0; i < num.length - 1 ; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if(ud == true) {	//올림
					if(num[i] > num[j]) {
						swap(num, i, j);
					}
					
				}else {	//내림
					if(num[i] < num[j]) {
						swap(num, i, j);
					}
					
				}
			}
		}
	}
	static void printing(int num[]) {
		for (int i = 0; i < num.length; i++) {
			System.out.println("number"+ (i + 1) + ":" + num[i]);
		}
		
	}
	static void swap(int num[], int i, int j) {
		
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}