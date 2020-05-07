package Controller;

import java.util.ArrayList;
import java.util.Calendar;

import DTO.CommentDTO;

public class CommentController {
	ArrayList<CommentDTO> list = new ArrayList<CommentDTO>();
	public CommentController() {
		CommentDTO c1 = new CommentDTO();
		c1.setId(1);
		c1.setBoardId(1);
		c1.setMemberId(1);
		c1.setContent("댓글1");
		c1.setWrittenDate(Calendar.getInstance());
		c1.setUpdateDate(Calendar.getInstance());
		list.add(c1);
	}
	//1.댓글을볼때 그글에 달린 댓글이 전부나옴
	//기본적으로 댓글 select할때 list를 반환(댓글을 하나만 볼일은 없으니 selectOne은 불필요)
	//작성자가 자기가 달은 댓글을 모아봐야하니 메소드가 하나더 필요
	
	public ArrayList<CommentDTO> selectByBoardId(int boardId){
		ArrayList<CommentDTO> boardIdList = new ArrayList<CommentDTO>();
		for(CommentDTO c : list) {
			if(c.getBoardId() == boardId) {
				boardIdList.add(c);
			}
		}
		return boardIdList;
	}
	public void insert(CommentDTO c) {
		c.setId(list.get(list.size()-1).getId()+1);
		c.setWrittenDate(Calendar.getInstance());
		c.setUpdateDate(Calendar.getInstance());
		list.add(c);
	}
	
}
