package study_1_jdbc;

import java.util.List;

public class mainClass {
	public static void main(String[] args) {
		DBConnection.initConnection();	//최초 한번 실행	
		JdbcTest jt  = new JdbcTest();
/*
		// Insert
			boolean a = jt.Insert("bbb", "일지매", 21);
			if(a) {
				System.out.println("정상적으로 추가 되었습니다.");
			}
			
		// Update	
			boolean b = jt.Update("bbb", 22);
			if(b) {
				System.out.println("성공적으로 수정되었습니다.");
			}
			
		// Delete	
			String id = "aaa";
			boolean c = jt.Delete(id);
			
			if(c) {
				System.out.println("성공적으로 삭제하였습니다.");
			}
		
		// Select
			SelectTest st = new SelectTest();
			String id1 = "ccc";
			UserDTO dto = st.Search(id1);
			if(dto != null) {
				System.out.println(dto.toString());
			}else {
				System.out.println("id를 찾을 수 없습니다");
			}
			
			id1 = "aaa";
			dto = st.select(id1);
			if(dto != null) {
				System.out.println(dto.toString());
			}else {
				System.out.println("id를 찾을 수 없습니다");
			}
*/			
		// Select 모두 보기
			SelectTest st = new SelectTest();
			List<UserDTO> list = st.getUserList();
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
					
	}
}