package main;

import db.DBConnection;
import view.loginView;


public class mainClass {

	public static void main(String[] args) {
		DBConnection.initConnection();		
		 new loginView();
		
	}

}
