package Controller;

import java.util.ArrayList;
import java.util.Calendar;

import DTO.AirplaneDTO;

public class AirplaneController {
	ArrayList<AirplaneDTO> list = new ArrayList<AirplaneDTO>();
	public AirplaneController() {
		
		AirplaneDTO a1 = new AirplaneDTO();
		a1.setId(1);
		a1.setStartCityId(1);
		a1.setEndCityId(2);
		a1.setDeparTime(Calendar.getInstance());
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, 14);
		cal.add(Calendar.MINUTE, 30);
		
		a1.setArrivalTime(cal);
		
		AirplaneDTO a2 = new AirplaneDTO();
		a2.setId(2);
		a2.setStartCityId(2);
		a2.setEndCityId(1);
		
		a2.setDeparTime(Calendar.getInstance());
		a2.setArrivalTime(Calendar.getInstance());
			
		list.add(a1);
		list.add(a2);	
	}
	
	public ArrayList<AirplaneDTO> selectAll(){
		return list;
	}
	
	public AirplaneDTO select(int id) {
		for (AirplaneDTO a : list) {
			if(a.getId() == id) {
				return a;
			}
		}
		return null;
	}
}
