package service.impl;

import java.util.List;

import dao.BbsDao;
import dao.impl.BbsDaoImpl;
import dto.BbsDto;
import service.BbsService;

public class BbsServiceImpl implements BbsService {

	BbsDao dao = new BbsDaoImpl();
	
	
	@Override
	public List<BbsDto> getBbsList() {
		return dao.getBbsList();
	}


	@Override
	public boolean addBbs(BbsDto dto) {
		return dao.addBbs(dto);
	}

}
