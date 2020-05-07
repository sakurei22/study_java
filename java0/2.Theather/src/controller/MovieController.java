package controller;

import java.util.ArrayList;

import dto.MovieDTO;

//실제론 Database와 통신을해서
//Database에 데이터를
//입력(creat)
//가져오기(Retrieve)
//수정(Update)
//삭제(Delete)
//하지만 우리는 Database가 없으므로 그런기능까진 하지않는다.
public class MovieController {
	ArrayList<MovieDTO> list;
	
	public MovieController() {
		list = new ArrayList<MovieDTO>();
		MovieDTO m = new MovieDTO();
		m.setId(10);
		m.setLength(120);
		m.setTitle("라이온킹");
		
		MovieDTO m2 = new MovieDTO();
		m2.setId(12);
		m2.setLength(90);
		m2.setTitle("겨울왕국");
		
		MovieDTO m3 = new MovieDTO();
		m3.setId(24);
		m3.setLength(100);
		m3.setTitle("정글북");
		
		list.add(m);
		list.add(m2);
		list.add(m3);
	}
	//selectAll 메소드는
	//DB에서 받아온 것들을 리스트에 담아서
	//Viewer로 보내중다.
	//우리는 DB가 따로 없으므로 컨트롤러가 생성되면서 3개의 영화를 리스트에 추가하고
	//그 리스트를 프로그램 종료 전까지 계속 사용하면서
	//유사DB처럼 사용하게 만든다.
	public ArrayList<MovieDTO> selectAll() {
		//우리가 만든 DB리스트를 메소드가 호출될 떄
		//리턴해준다.
		return list;
	}
	//select method는 사용자가 입력한
	//번호를 받아서 ArrayList.get method를 사용해서
	//MovieDTO 객체를 보내준다.
	public MovieDTO select(int index) {
		return list.get(index);
	}
	//사용자가 새로 입력하면 만들어지는 MovieDTO 객채를
	//파라미터로 받아서 우리의 리스트에 추가해주는 매소드
	public void insert(MovieDTO movieDTO) {
		//Database에는 auto_increment라는 
		//int를 1씩 증가시키면서 입력시켜주는 기능이 있지만
		//우리는 Database가 없으므로 직접 만들어준다.
		int lastId = list.get(list.size()-1).getId()+1;
		movieDTO.setId(lastId);
		list.add(movieDTO);
	}
	//사용자가 수정요청을 보낼때 같이 보내지는 movieDTO객체를
	//기존에 있던 객체를 삭제하고 해당 위치에 보내진 객체를 끼워 넣는 메소드
	public void update(MovieDTO movieDTO) {
		int index = list.indexOf(movieDTO);
		list.remove(index);
		list.add(index, movieDTO);
	}
	//사용자가 선택한 movieDTO 객체를 리스트에서 삭제하는 메소드
	public void delete(MovieDTO movieDTO) {
		list.remove(movieDTO);
	}
}
//	public ArrayList<MovieDTO> selcevtAll(){
//		ArrayList<MovieDTO> list = new ArrayList<MovieDTO>();
//		database와 통신해서 테이블을 모두 list에 추가한다.
//		return list;
//		}