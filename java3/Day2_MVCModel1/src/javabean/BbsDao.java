package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.BbsDto;

public class BbsDao {
	
	// singleton
	private static BbsDao dao = new BbsDao();
	private int btnNum = 1;
	private String how = "";
	private BbsDao() {
	}
	public static BbsDao getInstance() {
		return dao;
	}
	// TODO 게시글 1개 선택
	public BbsDto getOneBbs(int seq) {
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, "
				+ " WDATE, DEL, READCOUNT "
				+ " FROM BBS "
				+ " WHERE SEQ = ?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		BbsDto dto = null;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			rs = psmt.executeQuery();	//select문만 executeQuery
			
			if(rs.next()) {
			dto = new BbsDto(rs.getInt(1),	//seq,
					rs.getString(2),		//id, 
					rs.getString(3), 		//title, 
					rs.getString(4), 		//content, 
					rs.getString(5), 		//wdate, 
					rs.getInt(6),	 		//del, 
					rs.getInt(7) 	 		//readcount
					);
			}
			System.out.println(dto.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			// conn.rollback();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return dto;
	}
	// TODO 조회수 + 1
	public void readCount(int seq) {		
		String sql=" UPDATE BBS SET  "
				+" READCOUNT=READCOUNT+1 "
				+ " WHERE SEQ=? ";
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		try {
			conn = DBConnection.getConnection();	
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			
			psmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBClose.close(psmt, conn, rs);	
		}
	}
	
	// TODO 리스트 출력
	public List<BbsDto> getBbsList(int num){
		int a = num;
		System.out.println("a :" + a);
		String sql =  " SELECT RNUM, SEQ, ID, TITLE, CONTENT, WDATE, DEL, READCOUNT "
					+ " FROM "
							+ " (SELECT ROWNUM AS RNUM, SEQ, ID, TITLE, CONTENT, WDATE, DEL, READCOUNT "
							+ " FROM (SELECT * "
									+ " FROM BBS "
									+ " ORDER BY WDATE DESC)) "				// 최신 순서로 글 정렬
					+ " WHERE RNUM BETWEEN ? AND ?"; 
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<BbsDto> list = new ArrayList<>();
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1 , 10 * num - 9);
			psmt.setInt(2 , 10 * num);
			rs = psmt.executeQuery();	//select문만 executeQuery
			
			while(rs.next()) {
				
				BbsDto dto = new BbsDto(rs.getInt(2), //seq,
										rs.getString(3), //id, 
										rs.getString(4), //title, 
										rs.getString(5), //content, 
										rs.getString(6), //wdate, 
										rs.getInt(7), //del, 
										rs.getInt(8) //readcount
										);
				if(rs.getInt(7) == 0) {
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
	// TODO 글 삭제
	public boolean deleteBbs(int seq) {
		String sql = " UPDATE BBS "
				+ "SET DEL = 1"
				+ "WHERE SEQ = ? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;

		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {		
			DBClose.close(psmt, conn, null);			
		}		
		return count>0 ? true : false;
	}
	
	// TODO 글 수정
	public boolean updateBbs(int seq, String title, String content) {
		String sql = " UPDATE BBS "
				+ " SET CONTENT = ?,  TITLE = ? "
				+ " WHERE SEQ = ? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet  rs = null;
		int count = 0;
		
		try {
			
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, content);
			psmt.setString(2, title);
			psmt.setInt(3, seq);
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {		
			DBClose.close(psmt, conn, rs);			
		}		
		
		return count>0 ? true : false;
		
	}
	// TODO 검색
	public List<BbsDto> searchBbs(String how, String str) {
		String sql = " SELECT SEQ, ID, TITLE "
					+ " FROM BBS "
					+ " WHERE 1=1 ";
		if(how.equals("title")) {
				sql = sql + " AND TITLE LIKE ?";
			} else if(how.equals("id")) {
				sql = sql + " WHERE ID = ?";
			} else { // 내용
				sql = sql + " WHERE CONTENT LIKE ?";
			}
		sql = sql + " ORDER BY WDATE DESC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<BbsDto> list = new ArrayList<>();
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			
			if(how.equals("id")) {
				psmt.setString(1, str);
				
			}else if(how.equals("title")||how.equals("content")){
				psmt.setString(1, "%" +str + "%");
			}
			
			rs = psmt.executeQuery();	//select문만 executeQuery
			
			while(rs.next()) {	// 필요한 것만 가져옴. seq로 세부 목록 볼수 있게 함
				BbsDto dto = new BbsDto(rs.getInt(1), //seq,
										rs.getString(2), //id, 
										rs.getString(3), //title, 
										null, //content, 
										null, //wdate, 
										0, //del, 
										0 //readcount
										);
				
				list.add(dto);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// conn.rollback();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return list;
	}
}

