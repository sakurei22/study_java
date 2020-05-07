package day01;
//Switch
public class Ex04 {
	public static void main(String[] args) {
		//Switch는 한 변수의 나올수 잇는 값들을 모두 테스트하여 해당 값이 있는 케이스부터
		//break가 나오는 케이스까지 실행하게된다.
		int myNumber = 1;
		switch (myNumber) {
		case 1:
			System.out.println("1입니다");
			break; //break란? - 만나는 즉시 해당 code block을 탈출한다.
		case 2:
			System.out.println("2입니다");
			break;
		case 3:
			System.out.println("3입니다");
			break;
		default:
			System.out.println("그 외입니다");
			break;
		}
		
		//switch문의 예
		int httpStatuscode = 200;
		switch(httpStatuscode) {
			case 200:
				System.out.println("ok"); // response = "원래가야할 주소"; // "index/index.jsp"
				break;
			case 404:
				System.out.println("404 page Not Found"); // response = "redirect://error/404"
				break;
			case 403:
				System.out.println("403 Forbidden"); // response = "redirect://error/403"
				break;
			case 400:
				System.out.println("400 Bad Request"); // response = "redirect://error/400"
		}
	}
}
