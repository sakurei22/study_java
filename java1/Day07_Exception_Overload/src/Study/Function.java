package Study;

public class Function {
	public static void main(String[] args) {
		
		/*
 			가변인수
 			배열이나 개수가 정해져있지 않은 변수를 파라미터로 받을때 사용
		 */
		alloParameter(2, 3, 4);
		alloParameter(1, 2, 3, 4, 5, 6, 7);
		 alloc_Parameter("hello", 1,2,3);
	}
	
	static void alloParameter(int...ab) {	// 인수의 개수가 변할수있음
		int sum = 0;
		for (int i = 0; i < ab.length; i++) {
			sum = sum + ab[i];
			
		}
		
		System.out.println("합계: "+sum);
	}
								//getter
	static void alloc_Parameter( String str, int...ab) {	// 가변인수의 경우 갯수가 정해져있지 않기 떄문에
															// 뒤에다 적어야된다(요즘언어는 상관없음)
		int sum = 0;
		for (int i = 0; i < ab.length; i++) {
			sum = sum + ab[i];
			
		}
		
		System.out.println(str+"합계: "+sum);
	}
		
	
}
