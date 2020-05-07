package day04;

public class Ex02 {
public static void main(String[] args) {
	ConnectionMaker m = new OracleConnectionMaker();
	StudentController controller = new StudentController(m);
	
}
}
