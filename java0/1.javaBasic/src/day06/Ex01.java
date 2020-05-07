package day06;
//printf
public class Ex01 {
	//printf는 다양한 %문자를 써서
	//해당 데이터타입의 변수를 형식(format)에 맞춰어서 출력한다.
	// %d: 10진법
	// %x: 16진법
	// %f: 실수
	// %s: 문자열
	
	public static void main(String[] args) {
		int a =234;
		//1.상수 출력
		
		//\n: 줄바꿈
		//\t: 탭공백
		System.out.printf("%d\n", a);
		
		//2. 정수를 자릿수 맞춰 출력
		//예시: 5자리 맞춰서 출력
		System.out.printf("%5d\n", a);
		
		//3. 정수를 자릿수 맞춰 왼쪽빈공간을 0으로 채워서 출력
		System.out.printf("%05d\n", a);
		
		//4. 정수를 자릿수 맞춰어 왼쪽정렬
		//	단, 왼쪽정렬은 0을 붙여 정렬하기 기능이 불가능하다.
		//	왜? 오른쪾에 0이 붙으면 자릿수 표시인지 실제값인지 알 수 없기 때문이다.
		System.out.printf("%-5d\n", a);
		
		//5. 정수를 16진법으로 표기하기
		//%x -> a~f
		//%X -> A~F
		//%x 에는 %d의 옵션값(0,-,자릿수)가 동일하게 들어갈수있다.
		System.out.printf("%x\n", a);
		System.out.printf("%X\n", a);
		
		//%f: 실수
		double d = 3.141592;
		System.out.printf("%f\n", d);
		
		//%.2f: 소숫점 2자리까지 출력
		System.out.printf("%.2f\n", d);
		
		//%s: 스트링변수의 값을 출력
		System.out.printf("%s\n", "Hello, WORLD!!");
		
		//printf 다양한 %문자를 섞어 쓸 수 있습니다.
		//섞어 쓸때 뒤 변수는 , 로 구분합니다.
		System.out.printf("%d %s %05d %.3f", 1, "신종하", 467, 487/5.0);
	}
}
