package day02;
//암시적형변환
public class Ex02 {
	public static void main(String[] args) {
		//암시적형변환
		//더 작은 데이터타입을 큰 데이터타입으로 바꿀 때
		//아무런 명령어 없이 곧장 초기화가 가능하다.
		long i = 10;
		int l = (int)i;
		
		String str = "12345"+6;  // 6이먼저 문자열로 변환 123456
		int j = Integer.parseInt(str); // "123456" 을 123456으로
		System.out.println(j+6); // 123456+6
		
		
		
	}
}
