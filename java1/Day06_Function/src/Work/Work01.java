package Work;

//과제1 두점 사이거리
//	2 shuffle
//	3 max
//	4 isNumber
//	5 2배
//	6 암호화,복호화
public class Work01 {
	public static void main(String[] args) {
		// 과제1
		double d = getDistance(1, 1, 2, 2);
		System.out.println("과제1=" + d);
		System.out.println("============================");
		// 과제2
		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(java.util.Arrays.toString(original));
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
		System.out.println("============================");
		// 과제3
		int[] data = { 3, 2, 9, 4, 7 };
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값:" + max(data));
		System.out.println("============================");
		// 과제4
		String str = "123";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
		str = "1234o";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
		System.out.println("============================");
		// 과제5
		int num1[] = { 1, 2, 3, 4, 5 };
		getDouble(num1);

		// 결과 출력
		for (int i = 0; i < num1.length; i++) {
			System.out.println("getDouble[" + i + "]= " + num1[i]);
		}

		// 과제6 // abcdefghijklmnopqrstuvwxyz. 26 97~ 122
		String abc = "abcdefghijklmnopqrstuvwxyz";
		String num = "0123456789";
		char[] abcCode =

				{ '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '|', '[', ']', '{',
						'}', ';', ':', ',', '.', '/' };

		// 0 1 2 3 4 5 6 7 8 9. 10 48~57

		char[] numCode = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };

		String strPw = "as123";
		String password = getPW(strPw, abc, num, numCode, abcCode);
		System.out.println(password);

		String password1 =" `]wer";
		String repass = getWord(abc, num, numCode, abcCode, password1);
		System.out.println(repass);

	}

	static double getDistance(int x, int y, int x1, int y1) {
		// math.sqrt , math.pow
		// 두 점 (x,y)와 (x1,y1)간의 거리를 구한다.
		double d = Math.sqrt((Math.pow(x - x1, 2) + Math.pow(y - y1, 2)));
		return d;
	}

	static int[] shuffle(int[] original) {
		int w, r;
		boolean _switch[] = new boolean[9];
		for (int i = 0; i < _switch.length; i++) {
			_switch[i] = false;
		}
		w = 0;
		while (w < 9) {

			r = (int) (Math.random() * 9); // 0 ~ 8
			if (_switch[r] == false) {
				_switch[r] = true;
				original[w] = r + 1; // 1 ~ 9
				w++;
			}
		}

		return original;
	}

	static int max(int[] data) {
		int max = data[0];
		for (int i = 0; i < data.length; i++) {
			if (max < data[i]) {
				max = data[i];
			}
		}
		return max;
	}

	static boolean isNumber(String str) {
		boolean ok = true;
		for (int i = 0; i < str.length(); i++) {
			int n = str.charAt(i);
			if (n < 48 || n > 57) {
				ok = false;
				break;
			}
		}
		if (ok == false) {
			return false;
		}
		return true;
	}

	static void getDouble(int[] num1) {
		for (int i = 0; i < num1.length; i++) {
			num1[i] = num1[i] * 2;
		}

	}

	static String getPW(String strPw, String abc, String num, char[] numCode, char[] abcCode) {
		// 과제6 // String abc = "abcdefghijklmnopqrstuvwxyz" 26 97~ 122
		// String num = "0123456789" 10 48~57
		String str1 = "";
		for (int i = 0; i < strPw.length(); i++) {
			char ch = strPw.charAt(i);
			if ((int) ch >= 97 && (int) ch <= 122) {
				int n = abc.indexOf(ch);
				str1 = str1 + abcCode[n];
			} else if ((int) ch >= 48 && (int) ch <= 57) {
				int n = num.indexOf(ch);
				str1 = str1 + numCode[n];
			}
		}
		return str1;
	}

	static String getWord(String abc, String num, char[] numCode, char[] abcCode, String password1) {
		String str1 = "";
		for (int i = 0; i < password1.length(); i++) {
			char ch = password1.charAt(i);
			for (int j = 0; j < numCode.length; j++) {
				if (ch == numCode[j]) {
					str1 = str1 + num.substring(j, j+1);
				}
			}for (int j = 0; j < abcCode.length; j++) {
				if (ch ==abcCode[j]) {
					str1 = str1 + abc.substring(j, j+1);
				}
			}
		}
		return str1;
	}
}
