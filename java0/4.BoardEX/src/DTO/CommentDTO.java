package DTO;

import java.util.Calendar;

//댓글DTO
//id, 글번호(boardDToId), 작성자번호(MemberDto.id),
//댓글 내용. 입력날짜, 수정날짜
public class CommentDTO {
	private int id;
	private int boardId;	//데이터의 무결성:
	private int memberId;
	private String content;
	private Calendar writtenDate;
	private Calendar updateDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Calendar getWrittenDate() {
		return writtenDate;
	}
	public void setWrittenDate(Calendar writtenDate) {
		this.writtenDate = writtenDate;
	}
	public Calendar getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Calendar updateDate) {
		this.updateDate = updateDate;
	}


}
