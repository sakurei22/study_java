package day07;

import java.util.ArrayList;

import com.google.gson.Gson;

public class CarMain {
	public static void main(String[] args) {
		Car c = new Car();
		Gson g = new Gson();
		String json = "{\"id\":0,\"plateNumber\":\"00가 0000\",\"type\":\"모닝\",\"color\":\"빨간색\"}";
		c = g.fromJson(json, Car.class);
		System.out.println(c.getType());
		
	}
}
