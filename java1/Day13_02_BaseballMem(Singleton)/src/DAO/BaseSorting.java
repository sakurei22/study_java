package DAO;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

import DTO.Human;
import DTO.Pitcher;

public class BaseSorting implements DaoInterface{

	public BaseSorting() {
	}

	public void process() {
		Scanner sc = new Scanner(System.in);
		Singleton si = Singleton.getInstance();
		
		HashMap<String, Human> hashMap = new HashMap<String, Human>();	// 복사본
		Iterator<String> it = si.map.keySet().iterator();
		int w = 0; // 같은 키 값이 들어 가지 않도록 할 변수
		while (it.hasNext()) {
			String key = it.next();
			Human h = si.map.get(key);
			if (h instanceof Pitcher) {
				Pitcher p = (Pitcher) h;
				hashMap.put(p.getDefence() + "" + w, p);
				w++;
			}
		}

		TreeMap<String, Human> tMap = new TreeMap<String, Human>(hashMap);
		Iterator<String> updownIt = tMap.keySet().iterator();
		while (updownIt.hasNext()) {
			String key = updownIt.next();
			System.out.print("key:" + key + " ");
			Human h = tMap.get(key);
			System.out.println(h.toString());
		}
	}
}
