package study_1_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectTest {
	
	// 1개의 데이터(row)만 취득
	public UserDTO Search(String id) {
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
				+ " FROM USERDTO "
				+ " WHERE ID = '" + id + "'";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		
		ResultSet rs = null;	// 결과세팅
		UserDTO dto = null;	// null 이유: 밸류값이 하나라도 null일경우 못찾음
		
		System.out.println(sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			rs =psmt.executeQuery();	// 다른 함수들과 다른 메소드 : executeUpdate
			
			if(rs.next()) {	// rs데이터가 있는경우
				String _id = rs.getString("id");	//데이터 산출
				String _name = rs.getString("name");
				int _age = rs.getInt("age");
				String _joindate = rs.getString("joindate");
				
				dto = new UserDTO(_id,_name, _age, _joindate);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return dto;
	}
	
	public UserDTO select(String id) {
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
				+ " FROM USERDTO "
				+ " WHERE ID = ? ";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		UserDTO dto = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);	// 메소드의 매개변수를 통해 들어온 값이 '?'에 대입된다
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setJoindate(rs.getString("joindate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return dto;
	}
	
	// 데이터 다수 취득(2개 이상)
	
	// 모두
	public List<UserDTO> getUserList(){
		
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
				+ " FROM USERDTO ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<UserDTO> list = new ArrayList<UserDTO>();
		
		System.out.println("sql : "+ sql);
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {	// 데이터가 있을 때 까지
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String joindate = rs.getString("joindate");
				
				list.add(new UserDTO(id, name, age, joindate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return list;
	}
	

}














