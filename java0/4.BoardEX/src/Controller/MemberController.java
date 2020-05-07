package Controller;

import java.util.ArrayList;

import DTO.MemberDTO;

public class MemberController {
	ArrayList<MemberDTO> list;

	public MemberController() {
		list = new ArrayList<MemberDTO>();
		MemberDTO m = new MemberDTO();
		m.setId(1);
		m.setUserId("admin");
		m.setPassword("111");
		m.setName("관리자");

		MemberDTO m2 = new MemberDTO();
		m2.setId(2);
		m2.setUserId("user1");
		m2.setPassword("111");
		m2.setName("사용자1");

		MemberDTO m3 = new MemberDTO();
		m3.setId(3);
		m3.setUserId("user2");
		m3.setPassword("111");
		m3.setName("사용자2");

		list.add(m);
		list.add(m2);
		list.add(m3);

	}

	public MemberDTO selectOne(String userId, String password) {
		for (MemberDTO m : list) { // DB가 없으므로 for문으로 리스트에서 체크
			if (m.getUserId().equals(userId) && m.getPassword().equals(password)) {
				return m;
			}
		}
		return null;
	}

	public void insert(MemberDTO memberDTO) {
		boolean isAlready = false;
		for (MemberDTO m : list) {
			if (m.getUserId().equals(memberDTO.getUserId())) {
				isAlready = true;
			}
		}
		if (!isAlready) {
			int id = list.get(list.size() - 1).getId() + 1;
			memberDTO.setId(id);
			list.add(memberDTO);
		} else {
			System.out.println("이미 존재하는 ID입니다.");
		}
	}
	public String getWriterName(int id)	{
		for(MemberDTO m : list) {
			if(m.getId() == id) {
				return m.getName();
			}
		}
		return null;
	}
	public void update(MemberDTO m) {
		list.set(list.indexOf(m), m); 
	}
	public void delete(MemberDTO m) {
		list.remove(m);
	}
}








