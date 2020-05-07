package DAO;

import java.util.Iterator;
import DTO.Human;

public class BaseAllprint implements DaoInterface {

	public BaseAllprint() {
	}

	public void process() {
		Singleton si = Singleton.getInstance();
		Iterator<String> it = si.map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			Human h = si.map.get(key);
			System.out.println(h.toString());
		}
	}
}