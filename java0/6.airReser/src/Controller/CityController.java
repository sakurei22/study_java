package Controller;

import java.util.ArrayList;

import DTO.CityDTO;

public class CityController {
		ArrayList<CityDTO> list;
		public CityController() {
		list = new ArrayList<CityDTO>();
			
		CityDTO c1 = new CityDTO();
		c1.setId(1);
		c1.setCityName("서울");
		
		CityDTO c2 = new CityDTO();
		c2.setId(2);
		c2.setCityName("뉴욕");
		
		
		list.add(c1);
		list.add(c2);
		
		
	}
	public String getCityName(int id) {
		for(CityDTO c : list) {
			if(c.getId()==id) {
				return c.getCityName();
			}
		}
		return null;
	}
	public CityDTO selectOne(int id) {
		for(CityDTO c : list) {
			if(c.getId() == id) {
				return c;
			}
		}
		return null;
	}
}
