package study_1_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static void initConnection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!!"); // 드라이버가 존재하는지 확인

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.67:1521:xe", "hr", "hr");

			System.out.println("DB Connection Success!!"); // 디비와 연결확인

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
}
