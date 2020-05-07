package Study_2_2_Writer;

public class Pencil implements WriteMode {

	@Override
	public void writer() {
		System.out.println("연필로 기입합니다.");

	}
	
	public void erase() {
		System.out.println("지우개로 지웁니다.");
	}

}
