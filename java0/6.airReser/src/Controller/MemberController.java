package Controller;

import java.util.ArrayList;

import DTO.MemberDTO;

public class MemberController {
	ArrayList<MemberDTO> list;
	public MemberController() {
		list = new ArrayList<MemberDTO>();
		
		MemberDTO m1 = new MemberDTO();
		m1.setId(1);
		m1.setName("조재영");
		
		list.add(m1);
	}
	
	
}
