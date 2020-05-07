package Study_4_Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class mainClass {

	public static void main(String[] args) {
		/*
		 								Web -> Json
		 	HashMap : 사전
		 				사과	: apple
		 				key	: value -> 1쌍(pair)
		 				
		 			: Tree 구조 		0
		 						  0   0
		 					     0 0 0 0		
		 			: 중복 키 값을 사용할 수 없다.				cf) multi map.
		 			
		 			
		 	TreeMap = HashMap + sorting	
		 				sorting -> key값으로만 
		 */
		
		HashMap<Integer, String> hMap = new HashMap<Integer, String>();
//		Map<Integer, String> hMap = new HashMap<Integer, String>();
		
		// 추가
		hMap.put(111, "백십일");
		hMap.put(222, "이백이십이");
		hMap.put(333, "삼백삼십삼");
		
		// value취득
		String value = hMap.get(111);
		System.out.println("value = " + value);
		
		// 검색
			// 존재여부
		boolean b = hMap.containsKey(new Integer(333));
		System.out.println("b = "+ b);
		
			// 값을 취득
		if(hMap.containsKey(333)) {
			value = hMap.get(333);
			System.out.println("value = "+ value);
		}
		
		// 삭제
		String val = hMap.remove(222);
		System.out.println(val+" 값이 삭제되었습니다.");
		
		// 수정
		hMap.put(111, "100 + 10 + 1");	//중복 키값 허용 안됨.
//		value = hMap.get(111);
		
		hMap.replace(111, new String("1 + 10 + 100"));	// 정석
		value = hMap.get(111);
		System.out.println("value = " + value);
		
		// key 값을 모두 취득
		// iterator
		Iterator<Integer> it = hMap.keySet().iterator();
		while(it.hasNext()) {
			Integer key = it.next();		// key
			System.out.println("key : " + key);		// 순서 상관없이 출력
			
			String _val = hMap.get(key);
			System.out.println("val : " + _val);
		}
		
		HashMap<String, String> sMap = new HashMap<String, String>();
		//추가
		sMap.put("apple", "사과");
		sMap.put("pear", "배");
		sMap.put("grape", "포도");
		sMap.put("banana", "바나나");
		
		//취득
		String _value = sMap.get("grape");
		System.out.println("value : "+ _value);
		
		// 모두 출력
		Iterator<String> skey = sMap.keySet().iterator();
		while(skey.hasNext()) {
			String key = skey.next();
			String sval = sMap.get(key);
			System.out.println("key: "+ key + " / value: "+ sval);
		}
		
		// 정렬숫자, 문자  -> key값으로
		// TreeMap <--> Hashmap : 호환가능
		TreeMap<String, String> treeMap = new TreeMap<String, String>(sMap);
		
		//오름차순
	//	Iterator<String> itkey = treeMap.keySet().iterator();
		
		//내림 
		Iterator<String> itkey = treeMap.descendingKeySet().iterator();
		while(itkey.hasNext()){
			String key = itkey.next();
			System.out.println("key: " + key + " / value: "+ treeMap.get(key));
		}
		
		int count = 1;
		ArrayList<String> list = new ArrayList<String>();
		list.add("Tigers");
		list.add("Lions");
		list.add("Giants");
		
		HashMap<Integer, String> mymap = new HashMap<Integer, String>();
		for (int i = 0; i < list.size(); i++) {
			mymap.put(count, list.get(i));
			count++;
		}
		
		HashMap<Integer, MyData> dataMap = new HashMap<Integer, MyData>();
		//추가
		
			dataMap.put(1, new MyData(111, "aaa"));
	
			dataMap.put(2, new MyData(222,"bbb"));
		
			dataMap.put(3, new MyData(333, "ccc"));
		
			dataMap.put(4, new MyData(444,"ddd"));
		
			dataMap.put(5, new MyData(555, "eee"));
		//삭제
			MyData delm = dataMap.remove(2);
			System.out.println(delm+" 값이 삭제되었습니다.");
		
		//검색
	
					// 존재여부
				boolean b1 = dataMap.containsKey(new Integer(1));
				System.out.println("b1 = "+ b1);
				
					// 값을 취득
				if(dataMap.containsKey(1)) {
					MyData gm = dataMap.get(1);
					System.out.println("m = "+ gm);
				}
		//수정
				dataMap.replace(1, new MyData(666, "ggg"));	// 정석
				
		//출력
				Iterator<Integer> mkey = dataMap.keySet().iterator();
				while(mkey.hasNext()) {
					Integer key = mkey.next();
					MyData mval = dataMap.get(key);
					System.out.println("key: "+ key + " / "+ mval);
				}
	}
}













