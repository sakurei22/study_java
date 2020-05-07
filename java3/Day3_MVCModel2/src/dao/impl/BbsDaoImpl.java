package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BbsDao;
import db.DBClose;
import db.DBConnection;
import dto.BbsDto;

public class BbsDaoImpl implements BbsDao {

	@Override
	// TODO 게시판 전체 목록보기
	public List<BbsDto> getBbsList() {
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, "
				+ " WDATE, DEL, READCOUNT "
				+ " FROM BBS "
				+ " ORDER BY WDATE DESC "; // 최신 순서로 글 정렬
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<BbsDto> list = new ArrayList<>();
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();	//select문만 executeQuery
			
			while(rs.next()) {
				
				BbsDto dto = new BbsDto(rs.getInt(1), //seq,
										rs.getString(2), //id, 
										rs.getString(3), //title, 
										rs.getString(4), //content, 
										rs.getString(5), //wdate, 
										rs.getInt(6), //del, 
										rs.getInt(7) //readcount
										);
				if(rs.getInt(6) == 0) {
				list.add(dto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// conn.rollback();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return list;
	}

	@Override
	// TODO 글 추가
	public boolean addBbs(BbsDto dto) {
		String sql = " INSERT INTO BBS(SEQ, ID, TITLE, CONTENT, WDATE, DEL, READCOUNT) "
				+ " VALUES( SEQ_BBS.NEXTVAL, ?, ?, ?, SYSDATE, 0, 0 ) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet  rs = null;
		System.out.println("sql:" + sql);
		
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {		
			DBClose.close(psmt, conn, rs);			
		}		
		
		return count>0?true:false;
	}

}
