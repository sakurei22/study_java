package day04; //String

public class Ex03 {
	public static void main(String[] args) {
		// String
		// 문자열(문자가 여러개 모여있는것)을 뜻한다.
		// char들이 모여서 String이 된다.
		char a = 'a';
		// 이 코드는 에러가 난다.
		// chhr b = "abc"; //abc는 여러 글자가 모인 문자열이기 때문에 char에 들어갈 수 없다.
		// char는 ascii 테이블 기반의 코드값으로 진행되기 때문에
		// 아래 코드가 가능하다.
		System.out.println((char) ('A' + 32));
		// 왜? ascii 테이블에서 대문자 알파벳과 소문자 알파벳은 32만큼 차이가 있기 때문이다.
		// 대문자 코드값 + 32 = 소문자 코드값이 나와
		// 그 코드값을 char로 타입 캐스팅하면 소문자가 출력된다.

		// String 개게를 초기화하는 3가지 방법
		// 1. 기본생성자 호풀하고 초기화하기 -> 제일 안씀
		String str = new String();
		str = "abc";

		// 2. String 객체에 직접 값을 넣는 방법 -> 가장 많이 씀
		String str2 = "abcd";

		// 3. 생성자의 파라미터를 넘겨서 초기화하기
		String str3 = new String("abc");

		// String 클래스의 매소드들
		// 1. 비교할떄
		// String 은 클래스이므로 비교연산자를 사용하면
		// 주소값을 비교하게 된다.
		// 우리가 원하는 값비교를 하려면 equals 매소드를 통해 비교해야한다.
		System.out.println(str.equals(str3));

		// 2. 포함되었는지 확인할 때
		// String이 값이 다른 String을 포함하는지 체크할때에는
		// contains 매소드를 활용한다.
		// abcd안에 abc가 있는지 확인하는 코드
		System.out.println(str2.contains(str3));

		// 3. 대소문자 상관없이 비교할 때
		// 예를 들어 id를 캡스락을 키고 입력해도 정상적으로 인식되는
		// 코드를 작성할 때 사용가능하다.
		// abcd와 ABCD를 대소문자와 무관하게 비교하는 코드
		System.out.println(str2.equalsIgnoreCase("ABCD"));

		// 4. String의 길이를 체크할 때
		// abcd의 길이(4)를 보고 싶을 때
		// length() 메소드를 사용한다.
		System.out.println(str2.length());

		// 5. 특정 문자열 패턴을 만족하는지 체크할 때
		// matches() 메소드를 사용한다.
		// 패턴은 '정규표현식'(Regular Expression or RegEx)를 사용한다.
		// 숙제: 정규 표현식 조사
		// 아래코드는 str2가 숫자로만 이루어졌는지 확인한다.
		System.out.println(str2.matches("[0-9]"));
		// 정규표현식을 사용하면 이메일이 유효한 형태인지 확인 가능하다.

		// 6. 문자열에서 특정 문자열을 다른 문자열로 바꿀때
		// replace 메소드를 사용한다.
		// 아래코드는 abc를 xyc로 변환
		System.out.println(str.replace("ab", "xy"));

		// 7. 문자열을 잘라내서 다른 문자열에 저장할 때
		// subString을 사용한다.
		// subSting은 2가지 파라미터로 오버로딩되어있데
		// 하나는 시작지점~끝까지
		String subString = str.substring(1);
		System.out.println(subString);
		// 다른 하나는 시작지점~끝지점을 지정해주는 방식
		// str2 = abcd
		// 1번자리 이후~3번까지 = a다음부터 c까지 = bc
		subString = str2.substring(1, 3);
		System.out.println(subString);

		// 8. 모든 글자를 소문자로 바꿀때
		// toLowerCase 메소드를 실행.
		System.out.println("AbCdEfG".toLowerCase());

		// 9. 모든 글자를 대문자로 바꿀때
		// toUpperCase 메소드르 실행.
		System.out.println("AbCdEfG".toUpperCase());

		// 10. String도 toString()이 있다.
		// 물론 자기자신을 리턴한다.

		// 11. 앞뒤의 공백들을 짤라줄때에는
		// trim 메소드를 사용한다.
		System.out.println(str);
		System.out.println(str.trim());

		// 12. 기본형 데이터타입들의 값을 string으로 바꿔줄때에는
		// valueOf 메소드를 사용
		// 단 valueOf 메소드는 static 메소드이기 때문에
		// 아래의 코드처럼 쓴다.
		str = String.valueOf(1234);
		System.out.println(str);

		// 마지막으로 문자열은 + 연산이 가능하다.
		// +연산의 결과값은 2개를 연결시킨다.
		// 문자열 + 기본형 데이터타입도 기본형 데이터타입을
		// 문자열로 변경하고 연결시켜준다.
		System.out.println("a" + 123);
	}
}
