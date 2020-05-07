package Controller;

import java.util.ArrayList;
import java.util.Calendar;
import DTO.BoardDTO;

public class BoardController {
	ArrayList<BoardDTO> list;
	public BoardController() {
		list = new ArrayList<BoardDTO>();
		BoardDTO b= new BoardDTO();
		b.setId(0);
		b.setWriterId(1);
		b.setTitle("제목");
		b.setContent("제목");
		b.setWrittenDate(Calendar.getInstance());
		b.setUpdatedDate(Calendar.getInstance());
		
		BoardDTO b1=new BoardDTO();
		b1.setId(1);
		b1.setWriterId(2);
		b1.setTitle("제목1");
		b1.setContent("제목1");
		b1.setWrittenDate(Calendar.getInstance());
		b1.setUpdatedDate(Calendar.getInstance());
		
		BoardDTO b2 = new BoardDTO();
		b2.setId(2);
		b2.setWriterId(3);
		b2.setTitle("제목2");
		b2.setContent("제목2");
		b2.setWrittenDate(Calendar.getInstance());
		b2.setUpdatedDate(Calendar.getInstance());
		
		list.add(b);
		list.add(b1);
		list.add(b2);
				
	}
	public ArrayList<BoardDTO> selectAll(){
		return list;
	}
	
	public BoardDTO selectOne(int id) {
		for(BoardDTO b : list) {
			if(b.getId() == id) {
				return b;
			}
		}
		return null;
	}
	public void update(BoardDTO boardDto) {
		boardDto.setUpdatedDate(Calendar.getInstance());
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getId()== boardDto.getId()) {
				list.set(i, boardDto);
			}
		}
	}
	public void delete(BoardDTO boardDTO) {
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getId() == boardDTO.getId()) {
				list.remove(i);
			}
		}
	}
	public ArrayList<BoardDTO> selectAll(int id){
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		for(int i = 0; i<this.list.size(); i++) {
			if(this.list.get(i).getWriterId() ==id) {
				list.add(this.list.get(i));
			}
		}
		return list;
	}
	public void insert(BoardDTO b) {
		int id = list.get(list.size()-1).getId()+1;
		b.setId(id);
		list.add(b);
		
		
	}
}
