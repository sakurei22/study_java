package DTO;

import java.util.Calendar;

public class AirplaneDTO {
	private int id;
	private int startCityId;
	private int EndCityId;
	private Calendar deparTime;
	private Calendar arrivalTime;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getStartCityId() {
		return startCityId;
	}
	public void setStartCityId(int startCityId) {
		this.startCityId = startCityId;
	}
	public int getEndCityId() {
		return EndCityId;
	}
	public void setEndCityId(int endCityId) {
		EndCityId = endCityId;
	}
	public Calendar getDeparTime() {
		return deparTime;
	}
	public void setDeparTime(Calendar deparTime) {
		this.deparTime = deparTime;
	}
	public Calendar getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Calendar arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	
	
}
