package day04;

import java.sql.Connection;

public class OracleConnectionMaker implements ConnectionMaker {
	private final String URL = "Oracle 연결주소";
	private final String ID = "Oracle 연결ID";
	private final String PW = "Oracle 연결PW";
	public Connection makeConnection() {
		Connection conn = null;
		System.out.println("Oracle에 연결!!");
		//oracle 연결코드 입력
		return conn;
	}
}
