package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
	public JdbcTest() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!!"); // 드라이버가 존재하는지 확인

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.67:1521:xe", "hr", "hr");

			System.out.println("DB Connection Success!!"); // 디비와 연결확인

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public int insert(String id, String name, int age) {

		// createStatement, preparedStatement
		String sql = "INSERT INTO USERDTO(ID, NAME, AGE, JOINDATE) " + " VALLUES('" + id + "', '" + name + "', " + age
				+ ", " + ", SYSDATE) ";

		Connection conn = this.getConnection(); // 연결된 디비 불러옴
		Statement stmt = null;

		int count = 0; // 데이터가 몇개 변경되었는지 확인하는 변수
		System.out.println("sql:" + sql); // sql구문은 항상 확인하는것이 좋음

		try {
			stmt = conn.createStatement();
			count = stmt.executeUpdate(sql); // 데이터 삽입
			System.out.println("성공적으로 추가되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {

					stmt.close();
				}
				if (conn != null) {

					conn.close();

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
		return count;
	}
}