package controller;

import service.MemberService;
import service.impl.MemberServiceImpl;

public class MemberController {

	public MemberController() {
		MemberService memServ = new MemberServiceImpl();
	}
}
