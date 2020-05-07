package controller;

import java.util.List;

import dto.BbsDto;
import service.BbsService;
import service.impl.BbsServiceImpl;
import view.bbsListView;

public class BbsController {
	
	BbsService bbsServ = new BbsServiceImpl();
	
	public void getBbsList() {
		List<BbsDto> list = bbsServ.getBbsList();
		new bbsListView(list);
	}
	
	public boolean addBbsList(BbsDto dto) {
		boolean b = bbsServ.addBbs(dto);
		return b;
	}
}
