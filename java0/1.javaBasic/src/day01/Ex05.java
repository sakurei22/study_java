package day01;
//삼항연산자
public class Ex05 {
	public static void main(String[] args) {
		//삼항연산자란?
		//if나 switch 없이 조건문을 만든다.
		//다만, 단독실행을 불가하고 return이나 초기화에만 사용할 수 있다.
		
		String result = "";
		int myNumber1 = 10;
		int myNumber2 = 15;
		result = myNumber1 < myNumber2 ?
				"myNumber2가 더 큽니다.": "myNumber1이 더 큽니다.";
		//myNumber1 < myNumber2 ? System.out.println("myNumber2가 더 큽니다.")
		//	:System.out.println("myNumber1이 더 큽니다.");
		//위의 코드처럼 단독실행은 불가능한다.
		System.out.println(result);
		
		//윤년의 조건:
		//1. 4로 나누어 떨어지고
		//2. 4로 나누워 떨어지지만 100으로 안 나눠 떨어지고
		//3. 4로 나누어 떨어지고 100으로 나누어 떨어지지만 400으로도 나눠떨어짐.
		//이 3가지 조건을 이용하여 삼항연산자를 만들어서 1992년이 윤년인지 아닌지를 출력하시오.
		int year = 1990;
		result = year % 4 == 0 ?  year%100 == 0 ?
				year%400 == 0 ? "윤년 " : "평년 " : "윤년" : "평년";
		System.out.println(result);
		
	}
	
}
