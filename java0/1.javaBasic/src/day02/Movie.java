package day02;

// spring식으로 표현하면
// 테이블 하나당 3개의 클래스가 나오게된다.
// 데이터를 담는 클래스 하나(Data Transfer Object/ Value Object)
// DB와 통신을 담당하는 클래스 하나.(Controller)
// 화면으로 쏴주는 클래스 하나.(Viewer)
// 이렇게 Model - View - Controller로 분리해서 개발하는 패턴을 
// MVC패턴 이라고 한다.

public class Movie {
	//클래스 설계해보기
	//클래스 설계할때 중요한 것은
	//어떤 필드를 구상하고
	//또 그 클래스가 어떤 메소드를 실행할지를 고민해야한다.
	
	//필드를 구상할때에는
	//제일 먼저 int id 를 선언하여
	//관리번호를 가질 수 있게 한다.
	private int id;
	private String title;
	private int length;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", length=" + length + "]";
	}

	public Movie() {
		id = 0;
		title = "";
		length = 0;
	}
	//메소드의 경우
	//toString()과 기본 생성자는 만들어주는 것이 좋다.
	
}
