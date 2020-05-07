package dao;

import java.util.List;

import dto.BbsDto;

public interface BbsDao {
	
	public List<BbsDto> getBbsList();
	
	public boolean addBbs(BbsDto dto);
}
