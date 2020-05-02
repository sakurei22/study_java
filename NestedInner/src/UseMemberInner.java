interface Printable{
	void print();
}

class Papers{
	private String con;
	public Papers(String s) { con = s; }
	
	public Printable getPrinter() {
		return new Printer(); 	//멤버 클래스 인스턴스 생성 및 반환
	}
	
	private class Printer implements Printable {	//멤버 클래스의 정의
							//Printable 구현
		public void print() {
			System.out.println(con);
		}
	}
}

public class UseMemberInner {
	public static void main(String[] args) {
		Papers p = new Papers("내용 : 코딩천재가 되고 싶다");
		Printable prn = p.getPrinter();	//클래스의 정의가 감추어진 상황
		prn.print();
	}
}
