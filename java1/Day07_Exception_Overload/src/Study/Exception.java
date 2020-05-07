package Study;

public class Exception {
	public static void main(String[] args) {
		/*
		 * Exception : 예외 != 에러 개발자용(유지보수)
		 * 
		 * baseball -> 1 2 3 -> 'A' -> 65
		 * 
		 * number -> foramt | 1 2 3 -> 'A' array -> index number | int arr[] = new
		 * int[3] -> arr[3] class -> Scanner | import 안하면 못찾음 file -> 경로 | 못찾음
		 * 
		 * 
		 * int num[] = new int[2];
		 * 
		 * try{ num[2] = 'a'; // 예외가 발생할 가능성이 있는 코드
		 * 
		 * }catch(예외클래스1 e) // 에러가 난 것이 아님!! 메세지 }catch(예외클래스2 e) 메세지 }catch(예외클래스3 e)
		 * 메세지 }finally{ // 무조건 실행 // 뒤처리 // file close, DB원상복구(rollback, undo)
		 * 
		 * }
		 * 
		 */

		int num[] = { 11, 22, 33 };
		System.out.println("프로그램 시작");

		try {

			for (int i = 0; i < 4; i++) {
				System.out.println(num[i]);
			}
			System.out.println("배열출력완료");
		} catch (ArrayIndexOutOfBoundsException e) {
			// System.out.println("배열범위초과");
			// e.printStackTrace();
			System.out.println(e.getMessage());

			return;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally 무조건실행됨 ");
		}

		System.out.println("프로그램끝");
		funcExcp();
	}

	static void funcExcp()throws ArrayIndexOutOfBoundsException {
		int n[] = { 1, 2, 3 };
		//try {
			for (int i = 0; i < 5; i++) {
				System.out.println(n[i]);
			}
		//} catch (ArrayIndexOutOfBoundsException e) {
//			e.printStackTrace();
//		}
	}

}
