package main;

import DAO.Singleton;

public class mainClass {
	
	public static void main(String[] args) {
		
		new WindowClass();
		Singleton s = Singleton.getInstance();
		s.dataCls.readFile();
	}
}