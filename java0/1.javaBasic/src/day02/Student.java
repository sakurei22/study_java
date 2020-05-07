package day02;
//클래스 개념, 메소드선언방법( ex.equals)
public class Student {
	// 접근제한다
	// 접근 가능한 범위를 지정한다.
	// public: 어디서든지 접근 가능(같은 프로젝트 내부면)
	// protected: 같은 패키지 + 상속받는 클래스까지 접근 가능
	// package: 같은 패키지에서만 접근 가능(아무것도 안적어주면 package) 
	// 	default = package 와 같은 레벨
	// private: 같은 클래스에서만 접근 가능
				
		// private으로 된 필드들은 더이상 외부에서 값을 불러오거나 저장할 수 없다.
		// 따라서  method를 통하여 값을 저장하거나 불러오게 된다.
		// 그러한 method들을 getter/setter 라고 부른다.
		// /getter/setter들은 get필드이름, set 필드이름으로 이름 짓는다.
		
		private String name;
		// getter: 필드에 저장된 값을 호출된 곳으로 넘겨준다.
			public String getName( ) {
				return name;
		}
		// setter: 외부의 값을 필드에 저장한다.
			public void setName(String name) {
				this.name = name;
			}
		
		private int age;
			
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getKor() {
			return kor;
		}
		public void setKor(int kor) {
			this.kor = kor;
		}
		public int getEng() {
			return eng;
		}
		public void setEng(int eng) {
			this.eng = eng;
		}
		public int getMath() {
			return math;
		}
		public void setMath(int math) {
			this.math = math;
		}
		public String getJumin() {
			return jumin;
		}
		public void setJumin(String jumin) {
			this.jumin = jumin;
		}

		private int kor;
			
		private int eng;
			
		private int math;
			
		private String jumin;
		
		public void study() {
			System.out.println("공부합니다!!");
		}
		public void connectToMySql( ) {
			System.out.println("MySql연결!");
		}
		public void sing() {
			System.out.println("서울고등학교 교가를 부른다.");
		}
		public void goToSchool() {
			System.out.println("서울고등학교로 갑니다.");
		}	
		public void goToSchool(String schoolName) {
			System.out.println(schoolName+"고등학교로 갑니다.");
		}
		//public void goToSchool(String studentName)
		
		public int add(int a, int b) {
			return a+b;
		}
		public double add(double a, double b) {
			return a + b;
		}
		
		// 메소드 선언방법:
		// 접근제한자 리턴타입 메소드이름(파라미터)
		// 접근제한자: 해당 메소드나 필드가 어디서부터 접근가능한지 정해준다.
		// 리턴타입: 메소드가 끝난 후 호출 된 곳으로 보내줄 값의 데이터타입
		// 메소드이름: 호출될때 사용될 이름
		// 파라미터: 이 메소드에서 필요로 하는 외부의 값.
		// 파라미터는 데이터타입 파라미터이름 으로 이루어지는데
		// 파라미터이름은 외부에서 보내줄 변수의 이름과 일치할 필요가 없다.
		// 다만 메소드 내부에서는 파라미터의 이름으로 쓰이게 된다.
		public boolean equals(Object o) {
			if(o instanceof Student) {    // 왼쪽에 있는애가 오른쪽의 객채인지 확인
				Student s = (Student)o;  //형변환 (타입캐스팅)
				if(this.jumin.equals(s.jumin) &&
						this.name.equals(s.name)) { //this는 나중에 이 메소드를 호출할 객채
					return true;
				}
			}
			return false;
		}

		// 생성자(Constructor)
		// 생성자란? 해당 객체가 초기화될때 실행되는 메소드
		// 주로 필드의 초기화를 담당한다.
		// 자바가 기본적으로 제공하는 생성자가 필드의 값들을 초기화하는데
		// 필드의 데이터타입이 기본형이면 0
		// 데이터타입이 참조형이면 null로 초기화한다.
		
		// 그러면 생성자를 만들어보자. - 필드의 기본값이 꼭 필요한경우(ex.의존성 주입)
		// 생성자는 리턴타입이  없다.
		public Student() {
			name = "기본생성자가 생성된 이름";
			age = 1;
			kor = 0;
			eng = 0;
			math = 0;
			jumin = "기본생성자가 생성한 주민번호";
			
		}
		// 생성자는 파라미터가 있을 수 있습니다.
		public Student(String name, int age, int kor, int eng, int math, String jumin ) {
			this.name = name;
			this.age  = age;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
			this.jumin = jumin;
		}
		
		// override란?
		// 부모로부터 상속받는 메소드를
		// 자식 클래스가 재정의해서 사용하는 것.
		
		
		// overload란?
		// 같은 이름의 메소드지만
		// 파라미터 내용이 다른 메소드로서
		// 기능은 비슷하게 돌아간다.
		// 예를 들어 생성자 오버로딩이 있다.
		public String toString() {
			return "[name:"+name+", jumin:"+jumin+"]";
					
		}
}
