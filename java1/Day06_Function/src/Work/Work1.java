package Work;

public class Work1 {
	public static void main(String[] args) {
		// 1.두점사이거리
		double dis = getDistance(1, 1, 2, 2);
		System.out.println(dis);

		// 2. 셔플
		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(java.util.Arrays.toString(original));
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));

		// 3. max
		int[] data = { 3, 2, 9, 4, 7 };
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값:" + max(data));

		// 4. isNumber
		String str = "123";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
		str = "1234o";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));

		// 5. 암호화 복호화
		char[] abcCode =

				{ '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '|', '[', ']', '{',
						'}', ';', ':', ',', '.', '/' };

		char[] numCode = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };

		String src = "abc012";
		String secCode = "";

		secCode = security(src);
		System.out.println("원본: " + src);
		System.out.println("암호화: " + secCode);

		String oriCode = "";
		oriCode = deciphering(secCode);
		System.out.println("복호화= "+ oriCode);
	}

	static String security(String src) {
		/*
		 * 함수명 : security parameter : String return : String 내용 : 일반 문자와 숫자를 암호화하여 돌려주는
		 * 함수
		 * 
		 */
		char[] abcCode =

				{ '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '|', '[', ']', '{',
						'}', ';', ':', ',', '.', '/' };

		// 0 1 2 3 4 5 6 7 8 9. 10 48~57

		char[] numCode = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };

		String resultCode = "";
		for (int i = 0; i < src.length(); i++) {

			char ch = src.charAt(i); // 포문전에 문자 하나로 예제 만들기.(권장)
			int n = (int) ch;

			// 알파벳의 경우
			if (n >= 97 && n <= 122) {
				n = n - 97; // a -> 0
				resultCode = resultCode + abcCode[n];
			}
			// 숫자의 경우
			// if(n>=48 && n=<57) {
			else {
				n = n - 48;
				resultCode = resultCode + numCode[n];
			}

		}
		return resultCode;
	}

	static String deciphering(String src) {
		char[] abcCode =

				{ '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '|', '[', ']', '{',
						'}', ';', ':', ',', '.', '/' };

		// 0 1 2 3 4 5 6 7 8 9. 10 48~57

		char[] numCode = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };

		String oriStr = "";

		for (int j = 0; j < src.length(); j++) {

			char c = src.charAt(j);
			int n = (int) c;

			int index = 0;
			if (n >= 97 && n <= 122) { // 숫자
				for (int i = 0; i < numCode.length; i++) {
					if (c == numCode[i]) {
						index = i;
						break;
					}
				}
				index = index + 48;
				oriStr = oriStr + (char)index;

			} else { // 알파벳
				for (int i = 0; i < abcCode.length; i++) {
					if (c == abcCode[i]) {
						index = i;
						break;
					}
				}
				index = index + 97;
				oriStr = oriStr + (char)index;
			}
		}
		return oriStr;
	}

	static boolean isNumber(String num) {
		// boolean b = true;

		for (int i = 0; i < num.length(); i++) {
			int n = (int) num.charAt(i);
			if (n < 48 || n > 57) {
				// b = false;
				// break;
				return false;
			}
		}
		return true;
	}

	static String max(int[] array) {

		int max_num = array[0];
		for (int i = 0; i < array.length; i++) {
			if (max_num < array[i]) {
				max_num = array[i];
			}
		}
		return null;
	}

	static int[] shuffle(int[] original) {
		int temp;
		for (int i = 0; i < 1000; i++) {
			int r1 = (int) (Math.random() * original.length);
			int r2 = (int) (Math.random() * original.length);

			temp = original[r1];
			original[r1] = original[r2];
			original[r2] = temp;
		}
		return original;
	}

	static double getDistance(int x, int y, int x1, int y1) {
//		double dx, dy;
//		double result;
//		
//		dx = Math.pow(x1 - x, 2.0);
//		dy = Math.pow(y1 -y, 2.0);
//		
//		result =Math.sqrt(dy+dx);
//		
//		return result;

		return Math.sqrt(Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2));

	}

}
