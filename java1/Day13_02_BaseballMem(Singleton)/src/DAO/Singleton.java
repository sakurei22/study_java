package DAO;

import java.util.HashMap;
import DTO.Human;

public class Singleton {	// Delegate(= 대리인)
	
	private static Singleton single = null; 
	public HashMap<String, Human> map;
	public int MemNumber;
	
	private Singleton() {	
		map = new HashMap<String, Human>();
	}
	
	public static Singleton getInstance() {	
		if(single == null) {	
			single = new Singleton();
		}
		return single;	
	}
}

