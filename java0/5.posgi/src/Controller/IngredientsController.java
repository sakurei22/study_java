package Controller;

import java.util.ArrayList;

import DTO.IngredientsDTO;


public class IngredientsController {
	ArrayList<IngredientsDTO> list; // = new ArrayList<IngredientsDTO>();
	public IngredientsController() {
		list = new ArrayList<IngredientsDTO>(); //ArrayList<IngredientsDTO> list = new ArrayList<IngredientsDTO>();
		IngredientsDTO i = new IngredientsDTO();
		i.setId(0);
		i.setTitle("치즈");
		i.setFood("피자");
		i.setCost(500);
		
		IngredientsDTO i1 = new IngredientsDTO();
		i1.setId(1);
		i1.setTitle("병아리");
		i1.setFood("치킨");
		i1.setCost(300);
		
		IngredientsDTO i2 = new IngredientsDTO();
		i2.setId(2);
		i2.setTitle("돼지");
		i2.setFood("족발");
		i2.setCost(700);
		
		list.add(i);
		list.add(i1);
		list.add(i2);
				
	}
	
	public ArrayList<IngredientsDTO> selectAll(){
		return list;
	}
	
	public IngredientsDTO selectOne(String title)	{
		for(IngredientsDTO i : list) {
			if(i.getFood().equals(title))
				return i;
		}
		 return null;
	}
	
}
