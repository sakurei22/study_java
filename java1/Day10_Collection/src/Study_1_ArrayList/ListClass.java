package Study_1_ArrayList;

import java.util.ArrayList;


public class ListClass {
	public static void main(String[] args) {
		/*
		  	
		  	List : 목록
		  	관리를 유동적 할 수 있는 배열.
		  	
		  	목적 : 데이터를 효율적으로 관리하기 위한 목록을 사용
		  	collection: 수집(데이터)
		  	
		  	<List>
		  	ArrayList(Vector)
		  				배열처럼 사용할 수 있는 목록
		  				선형구조 0-0-0-0...
		  				검색 속도가 빠르다
		  				index number 로 관리된다. 0 ~ n-1
		  	LinkedList
		  				빈번하게 추가, 삭제의 작업이 필요한 경우 사용하기 적합하다.
		  	
		  	<Map>
		  	HashMap
		  				key & value 로 관리	"apple" : "사과"		
		  				(xml -> Json)		 key      value
		  				key중복을 허용하지 않음
		  				tree 구조(검색속도 우수)
		  	TreeMap
		  				soring
		
		 */
		
		
		ArrayList<Integer> arrList = new ArrayList<>();
		// List<Integer> list = new ArrayList<>();
		
		//추가(뒤에)
		arrList.add(111);				//wrapper 클래스에서만 이런식으로 사용가능
		
		Integer in = new Integer(222);  //일반클래스이용시 항상 생성해서 넣어줘야한다.
		arrList.add(in);
		
		arrList.add(new Integer(333));	//생성과 동시에 대입
		
		//추가(원하는 위치)
		Integer num = new Integer(123);
		arrList.add(1, num);
		
		// list size
		int len = arrList.size();
		System.out.println("리스트의 크기: "+len);
		
		//산출
		Integer out = arrList.get(0);		//arrlist[0]
		System.out.println("리스트 0번째: "+out);
		
		for (int i = 0; i < arrList.size(); i++) {
			Integer var = arrList.get(i);
			System.out.println("arrList[" + i + "] = " + var);
		}
		for(Integer i : arrList) {
			System.out.println(i);
		}
		
		//삭제
		arrList.remove(2);
		for (int i = 0; i < arrList.size(); i++) {
			Integer var = arrList.get(i);
			System.out.println("arrList[" + i + "] = " + var);
		}
		
		//검색
		int findIndex = arrList.indexOf(333);			//wrapper class라 가능
		System.out.println("findIndex: " + findIndex);
		
		findIndex = -1;
		for (int i = 0; i < arrList.size(); i++) {
			Integer var = arrList.get(i);
			if(var == 123) {
				findIndex = i;
				break;
			}
		}
		System.out.println("findIndex: " + findIndex);
		
		//수정
		Integer updateData = new Integer(555);
		arrList.set(2, updateData);
		for(Integer i : arrList) {
			System.out.println(i);
		}
		
		//String
		/*
		 	축구 테니스 야구 농구 스키 탁구
		 */
		
		ArrayList<String> arrSport = new ArrayList<>();
		//추가
		arrSport.add("축구");
		arrSport.add(new String("야구"));
		String str = new String("농구");
		arrSport.add(str);
		//원하는곳추가
		arrSport.add(1, "테니스");
		
		//검색
		
		//산출
		arrSport.get(1);
		
		for (int i = 0; i < arrSport.size(); i++) {
			System.out.println(arrSport.get(i));
		}
		
		//수정
		int findIndex1 = -1;
		String str1 = "탁구";
				for (int i = 0; i < arrSport.size(); i++) {
					if(str1.equals(arrSport.get(i))) {
						findIndex = i;
						break;
					}
				}
		arrSport.set(findIndex1, "탁구");
		
		//삭제
	}
}
