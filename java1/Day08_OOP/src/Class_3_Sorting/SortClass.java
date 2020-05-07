package Class_3_Sorting;

import java.util.Scanner;

public class SortClass {
	private int number[];
	private boolean updown;

	public void init() {

		Input();
	}

	public void Input() {
		Scanner sc = new Scanner(System.in);

		// count
		System.out.print("몇개의 숫자를 정렬하시겠습니까? = ");
		int count = sc.nextInt();

		// allocation(할당)
		String strNum[] = new String[count];

		// 정렬할 숫자들을 입력
		boolean ok = true;

		int w = 0;
		while (w < strNum.length) {
			ok = true;

			System.out.print((w + 1) + "번째 수 = ");
			strNum[w] = sc.next();

			// 정상적으로 숫자를 입력했는지 확인 123 1ab
			for (int i = 0; i < strNum[w].length(); i++) {
				int n = strNum[w].charAt(i);
				if (n < 48 || n > 57) {
					ok = false;
					break;
				}
			}
			if (ok == false) { // 문자가 있을 시에
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주십시오");
				continue;
			}
			w++;
		}

		// 올림/내림
		System.out.print("올림(1)/내림(2) = ");
		int ud = sc.nextInt();
		if (ud == 1)
			updown = true;
		else
			updown = false;

		for (int i = 0; i < strNum.length; i++) {
			System.out.println("strNum[" + i + "] = " + strNum[i]);
		}

		number = new int[strNum.length];
		for (int i = 0; i < number.length; i++) {
			number[i] = Integer.parseInt(strNum[i]);
		}
	}

	public void sorting() {

		for (int i = 0; i < number.length - 1; i++) {
			for (int j = i + 1; j < number.length; j++) {
				if (updown == true) { // 올림
					if (number[i] > number[j]) {
						swap(i, j);
					}
				} else { // 내림
					if (number[i] < number[j]) {
						swap(i, j);
					}
				}
			}
		}
	}

	public void swap(int i, int j) {
		int temp = number[i];
		number[i] = number[j];
		number[j] = temp;
	}

	public void resultPrint() {
		if (updown)
			System.out.println("올림차순으로 정렬하였습니다.");
		else
			System.out.println("내림차순으로 정렬하였습니다.");

		for (int i = 0; i < number.length; i++) {
			System.out.println("number" + (i + 1) + ":" + number[i]);
		}
	}
}
