package Study_3_LinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class mainClass {
	public static void main(String[] args) {
		/*
		 	ArrayList : 검색 우수		== Vector
		 	LinkedList : 추가, 삭제 (실시간) 우수
		 	
		 */
		
		Vector<String> vec = new Vector<String>();
		vec.add("라이온즈");
		vec.size();
		
		LinkedList<String> list = new LinkedList<String>();
		//List<String> list = new LinkedList<String>();
		
		if(list.isEmpty()) {
			System.out.println("데이터가 하나도 업습니다.");
		}
		
		list.add("Tigers");
		list.add("Giants");
		list.add(1,"Lions");
		
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			System.out.println(s.toString());
		}
		
		//맨 처음 요소에 추가
		list.addFirst("Bears");
		
		//맨 끝 요소에 추가
		list.addLast("Twins");
		
		for (String string : list) {
			System.out.println(string);
		}
		
		// iterator : 반복자 == 포인터(주소)  // Map에서 중요!!
		Iterator<String> it;	// String s;
		
		it = list.iterator();
		while(it.hasNext()) {
			String string = it.next();
			System.out.println("it: " + string);
		}
		
		ArrayList<String> arrlist = new ArrayList<String>(list); //호환가능 - 즉, 검색할때 넘겨주면 된다.
		for (int i = 0; i < arrlist.size(); i++) {					// 유리한 기능이 있는 리스트로.
			System.out.println(arrlist.get(i));
		}
	}
}
