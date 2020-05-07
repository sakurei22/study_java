package Controller;

import java.util.ArrayList;

import DTO.FoodDTO;


public class FoodController {
	ArrayList<FoodDTO> list;

	public FoodController() {
		list = new ArrayList<FoodDTO>();
		FoodDTO f = new FoodDTO();
		f.setId(0);
		f.setTitle("피자");
		f.setCost(2000);

		FoodDTO f1 = new FoodDTO();
		f1.setId(1);
		f1.setTitle("치킨");
		f1.setCost(1500);

		FoodDTO f2 = new FoodDTO();
		f2.setId(2);
		f2.setTitle("족발");
		f2.setCost(3000);

		list.add(f);
		list.add(f1);
		list.add(f2);

	}

	public ArrayList<FoodDTO> selectAll(){
		return list;
	}
	
	public FoodDTO selectOne(String id)	{
		for(FoodDTO f : list) {
			if(f.getTitle().equals(id))
				return f;
		}
		 return null;
	}
	
	
}


