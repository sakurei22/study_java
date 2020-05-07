package Function1;

//함수
public class mainClass {

	public static void main(String[] args) {

/*
  	function : 함수, 독립적			C언어 - function
  	method : 함수, 클래스에 종속적		Java - class
  	
  	<구성요소>
	들어가는값(입력)	: 매개변수, 인수, 인자, parameter (n개 가능)
	
	함수	: 처리
	
	돌려주는값(출력)	: return value (1개 이거나 0)
	
		Oracle - PL(Oracle언어를 함수화)
		
	<형식>
	return값(자료형)		함수명( 자료형 변수(가인수), 자료형 변수, ... ) {
						  
		처리
		
		return 값;
	}
	
	<예시>
	리턴값: int, float, double, String[], void(return값이 없음)
	int functionName(char c, int i){	가인수 : 로컬변수와 비슷하지만 외부에서 특정값이 들어온다
		처리
		return 값;
	}
	
	<장점>
	코드를 간략화할 수 있다.
	동일한 처리의 코드를 여러변 작성할 필요가 없다.
	소스의 분업이 가능해진다.
	
	
 */
		
	
	funcName(); // 함수호출
	
	int n = 17;
	funcName1(n);
	funcName2("hello", 'a');
	
	int r;
	r = funcName3(123.567);
	
	int asciiNum;
	asciiNum = getASCIIcode('a');
	
	double d = funcName4();
	
	
	
	
	}
	
	static void funcName() {
		System.out.println("funcName() 호출");
	}
	
	static void funcName1(int i) {
		System.out.println("funcName1(int i) 호출 i =" +i);
	}
	
	static void funcName2(String str, char c) {
		System.out.println("funcName2(String str, char c)");
		System.out.println("str = "+str);
		System.out.println("c ="+c);
		
		str = "world";
		System.out.println("str = "+ str);
		
	}
	
	static int funcName3(double d) {
		System.out.println("funcName3(double d");
		System.out.println("d= "+d);
		return 11;
	}
	
	static int getASCIIcode(char c) {
		return (int)c;
	}
	
	static double funcName4() {
		return 1.2345;
	}
}
