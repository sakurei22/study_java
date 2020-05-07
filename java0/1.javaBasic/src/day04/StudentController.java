package day04;

import java.sql.Connection;
import java.util.ArrayList;

public class StudentController {
	private Connection conn;	//DB와 연결을하는 객체
	StudentController(ConnectionMaker m){
		conn = m.makeConnection();
	}
	//이후 코드에서는 conn 객체를 사용하여 DB에 query를 보내고
	//결과를 ResultSet 객체에 담거나
	//입력, 수정, 삭제를 실행한다.
	//conn이 없으면?
	
	
}

