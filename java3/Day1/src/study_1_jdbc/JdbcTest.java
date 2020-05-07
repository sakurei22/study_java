package study_1_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public boolean Insert(String id, String name, int age) {
		// Statement 준비하는 두가지 방법
		// createStatement, preparedStatement
		String sql = "INSERT INTO USERDTO(ID, NAME, AGE, JOINDATE) " + " VALUES('" + id + "', '" + name + "', " + age
				+", SYSDATE) ";

		Connection conn = DBConnection.getConnection(); // 연결된 디비 불러옴
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
				e.printStackTrace();

			}
		}
		return count>0? true: false;
	}
	
	public boolean Delete(String id) {
		String sql = "DELETE FROM USERDTO"
				+ " WHERE ID = '"+ id +"'";
		Connection conn = DBConnection.getConnection(); // 연결된 디비 불러옴
		Statement stmt = null;
		int count = 0;
		System.out.println("sql:" + sql);

		try {
			stmt = conn.createStatement();
			count = stmt.executeUpdate(sql); // 데이터 삭제
			System.out.println("성공적으로 삭제되었습니다.");

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
				e.printStackTrace();
			}
		}
		return count>0? true: false;
	}
	public boolean Update(String id, int age) {
		String sql = "UPDATE FROM USERDTO"
				+ " SET AGE = "+age+" "
				+ " WHERE ID = '"+id+"'";
		// PreparedStatement
		Connection conn = DBConnection.getConnection();
		PreparedStatement stmt = null;
		int count = 0;
		System.out.println("sql:" + sql);
		
		try {
			
			stmt = conn.prepareStatement(sql);
			count = stmt.executeUpdate(); // 데이터 수정
			System.out.println("성공적으로 수정되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, conn, null);
		}
		return count>0? true: false;
	}
	
	
}