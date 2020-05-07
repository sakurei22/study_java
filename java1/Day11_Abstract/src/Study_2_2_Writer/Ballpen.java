package Study_2_2_Writer;

public class Ballpen implements WriteMode {

	@Override
	public void writer() {
		System.out.println("볼펜으로 기입합니다.");

	}
	
	public void erase() {
		System.out.println("화이트로 지웁니다.");
	}

}
