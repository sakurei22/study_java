package Studey_1_Singleton_pattern;

public class Singleton {
	
	private static Singleton single = null; //멤버 변수
	public int num;			// 주고 받을 변수 공간 필요
	public String name;		// 어떤 클래스에서든지 접근할수 있어야하기 때문에 public
	
	private Singleton() {	//생성자 앞에 private: 외부에서 Singleton 인스턴스 생성불가
		
	}
	
	public static Singleton getInstance() {	//메소드 호출뒤
		if(single == null) {	// 인스턴스 없으면 하나 생성
			single = new Singleton();
		}
		return single;	//기존에 인스턴스를 계속 리턴
	}
}