package day07;

import com.google.gson.Gson;

//JSON 직접 만들어보기
//JavaScript Object Notation
public class Car {
	private int id;
	private String plateNumber;
	private String type;
	private String color;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		//JSON에서 개게는 { } 으로 묶인다.
		//스트링밸류값은 ""으로 묶는다.
		//필드 이름을 key라고 부르고 실제 들어오는값을 value라고 칭한다.
		//key는 항상 String이고 ""으로 묶는다.
		//value는 int 나 String이 될수 있고 String일떄는 ""로 묶는다.
		
		//mvnrepository.com -> gson
		Gson g = new Gson();
		return g.toJson(this).toString();
		
	
	
	
	}

}























