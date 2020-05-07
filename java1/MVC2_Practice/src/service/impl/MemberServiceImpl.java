package service.impl;

import dao.MemberDao;
import dao.imipl.MemberDaoImpl;
import service.MemberService;

public class MemberServiceImpl implements MemberService {
	
	MemberDao dao = new MemberDaoImpl();
}
