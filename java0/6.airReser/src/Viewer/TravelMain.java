package Viewer;

import java.util.Scanner;

import Controller.AirplaneController;
import Controller.CityController;
import Controller.MemberController;
import Controller.ResvController;
import DTO.AirplaneDTO;
import DTO.CityDTO;

public class TravelMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ResvController resvController = new ResvController();
		AirplaneController airplaneController = new AirplaneController();
		MemberController memberController = new MemberController();
		CityController cityController = new CityController();

		for(AirplaneDTO a : airplaneController.selectAll()) { // 어레이리스트 리스트 는 에어플레인컨트롤러 셀렉트올 의 결과물이므로 바로 에어플레인디티오 a 로
																// ArrayList<AirplaneDTO> list = airplanController.selectAll() -> AirplaneDTo a
			CityDTO c2 = cityController.selectOne(a.getEndCityId());
			System.out.println(a.getId()+" "
			+cityController.selectOne(a.getStartCityId())+" "+a.getArrivalTime()
			+cityController.selectOne(a.getEndCityId())+" "+a.getDeparTime());
			
			
		}
		
		
		scan.close();
	}
}


























